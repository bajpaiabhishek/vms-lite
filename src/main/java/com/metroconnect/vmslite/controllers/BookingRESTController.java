package com.metroconnect.vmslite.controllers;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metroconnect.vmslite.dto.BookingDto;
import com.metroconnect.vmslite.dto.UnboundSlotsDto;
import com.metroconnect.vmslite.dto.VehicleDto;
import com.metroconnect.vmslite.services.BookingService;
import com.metroconnect.vmslite.services.MetroService;
import com.metroconnect.vmslite.services.UnboundSlotsService;
import com.metroconnect.vmslite.services.VehicleService;
import com.metroconnect.vmslite.utils.BookingStatus;
import com.metroconnect.vmslite.utils.ResponseMessage;
import com.metroconnect.vmslite.utils.VmsDateFormat;

@RestController
@RequestMapping("/api/v1")
public class BookingRESTController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private MetroService metroService;

	@Autowired
	private UnboundSlotsService unboundSlotsService;

	@Value("${service.start.date}")
	private String serviceStartDate;

	@PostMapping("/book")
	public ResponseEntity<ResponseMessage> createNewBooking(@RequestBody Map<String, String> payload) {
		
		// extract data from request payload
		String sourceCity = payload.get("source");
		String destinationCity = payload.get("destination");
		String pickUpDate = payload.get("pickup");
		String customerEmail = payload.get("customer");

		ResponseMessage response = new ResponseMessage();

		// validation for source city
		if (sourceCity == null | sourceCity.trim().isEmpty()) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Enter valid source city");
			return ResponseEntity.badRequest().body(response);
		}

		sourceCity = sourceCity.toUpperCase();
		if (!metroService.getAllSourceCities().contains(sourceCity)) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("We currently do not service this city.");
			return ResponseEntity.badRequest().body(response);
		}

		// validation for destination city
		if (destinationCity == null | destinationCity.trim().isEmpty()) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Enter valid destination city");
			return ResponseEntity.badRequest().body(response);
		}
		
		destinationCity = destinationCity.toUpperCase();
		if (!metroService.getAllDestinationCities().contains(destinationCity)) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("We currently do not service this city.");
			return ResponseEntity.badRequest().body(response);
		}

		// validation for input date
		Date pickup = null;
		try {
			pickup = VmsDateFormat.sdf.parse(pickUpDate);
		} catch (ParseException e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Invalid Date. Use format - dd-MM-yyyy");
			return ResponseEntity.badRequest().body(response);
		}

		try {
			if (VmsDateFormat.sdf.parse(serviceStartDate).compareTo(pickup) > 0) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("Our services starts on - " + serviceStartDate);
				return ResponseEntity.badRequest().body(response);
			}
		} catch (ParseException e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("Something Went Wrong.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}

		// validate customer email
		if (customerEmail == null | customerEmail.trim().isEmpty()
				| !Pattern.compile("^(.+)@(.+)$").matcher(customerEmail).matches()) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Enter valid customer email");
			return ResponseEntity.badRequest().body(response);
		}

		// schedule from unbound slots
		Date delivery = getDeliveryDate(sourceCity, destinationCity, pickup);
		List<UnboundSlotsDto> unboundSlotsForMetro = unboundSlotsService.findAllVehiclesAvailable(pickup, delivery,
				sourceCity);
		if (unboundSlotsForMetro.size() > 0) {
			int index = new Random().nextInt(unboundSlotsForMetro.size());
			UnboundSlotsDto unboundSlot = unboundSlotsForMetro.get(index);
			int cost = metroService.getCost(sourceCity, destinationCity);
			if (unboundSlot.getStartDate().compareTo(pickup) < 0) {
				UnboundSlotsDto unboundSlotDto = new UnboundSlotsDto(unboundSlot.getStartDate(), pickup,
						unboundSlot.getVehicleNumber(), unboundSlot.getSourceMetro());
				unboundSlotsService.save(unboundSlotDto);
			}
			if (unboundSlot.getEndDate().compareTo(delivery) > 0) {
				UnboundSlotsDto unboundSlotDto = new UnboundSlotsDto(delivery, unboundSlot.getEndDate(),
						unboundSlot.getVehicleNumber(), unboundSlot.getSourceMetro());
				unboundSlotsService.save(unboundSlotDto);
			}
			unboundSlotsService.remove(unboundSlot);
			BookingDto newBooking = new BookingDto(sourceCity, destinationCity, pickup, delivery, customerEmail,
					unboundSlot.getVehicleNumber(), cost, 100, BookingStatus.INITIATED);
			BookingDto booking = bookingService.save(newBooking);
			response.setStatus(HttpStatus.OK);
			response.setMessage("Booking Confirmed");
			Map<String, String> result = new HashMap<String, String>();
			result.put("Vehicle Number", String.valueOf(unboundSlot.getVehicleNumber()));
			result.put("Booking Id", String.valueOf(booking.getId()));
			result.put("Cost", String.valueOf(booking.getCost()));
			response.setPayload(result);
			return ResponseEntity.ok().body(response);
		}

		
		//schedule from available vehicles
		List<VehicleDto> availableVehicles = vehicleService.findAllVehiclesAvailable(pickup, sourceCity);
		if (availableVehicles.size() > 0) {
			int index = new Random().nextInt(availableVehicles.size());
			VehicleDto vehicle = availableVehicles.get(index);
			int offset = metroService.getTravelDays(sourceCity, destinationCity);
			int cost = metroService.getCost(sourceCity, destinationCity);
			if (vehicle.getAvailability().compareTo(pickup) != 0) {
				UnboundSlotsDto unboundSlot = new UnboundSlotsDto(vehicle.getAvailability(), pickup,
						vehicle.getVehicleNumber(), vehicle.getSourceMetro());
				unboundSlotsService.save(unboundSlot);
			}
			vehicle = vehicleService.updateAvailability(pickup, vehicle, offset);
			BookingDto newBooking = new BookingDto(sourceCity, destinationCity, pickup, vehicle.getAvailability(),
					customerEmail, vehicle.getVehicleNumber(), cost, 100, BookingStatus.INITIATED);
			BookingDto booking = bookingService.save(newBooking);
			response.setStatus(HttpStatus.OK);
			response.setMessage("Booking Confirmed");
			Map<String, String> result = new HashMap<String, String>();
			result.put("vehicle Number", String.valueOf(vehicle.getVehicleNumber()));
			result.put("Booking Id", String.valueOf(booking.getId()));
			result.put("Cost", String.valueOf(booking.getCost()));
			response.setPayload(result);
			return ResponseEntity.ok().body(response);
		} else {
			response.setStatus(HttpStatus.OK);
			response.setMessage("Vehicle not available");
			return ResponseEntity.ok().body(response);
		}

	}

	private Date getDeliveryDate(String sourceCity, String destinationCity, Date pickup) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pickup);
		calendar.add(Calendar.DATE, metroService.getTravelDays(sourceCity, destinationCity));
		return calendar.getTime();
	}

}


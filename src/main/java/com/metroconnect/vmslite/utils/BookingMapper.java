package com.metroconnect.vmslite.utils;

import com.metroconnect.vmslite.dto.BookingDto;
import com.metroconnect.vmslite.model.Booking;

public class BookingMapper {

	public static BookingDto toBookingDto(Booking booking) {

		return new BookingDto(booking.getId(), booking.getSource(), booking.getDestination(), booking.getTransitDate(),
				booking.getDeliveryDate(), booking.getCustomerEmail(), booking.getVehicleNumber(), booking.getCost(),
				booking.getWeight(), booking.getBookingStatus());
	}

	public static Booking toBookingEntity(BookingDto booking) {

		return new Booking(booking.getId(), booking.getSource(), booking.getDestination(), booking.getTransitDate(),
				booking.getDeliveryDate(), booking.getCustomerEmail(), booking.getVehicleNumber(), booking.getCost(),
				booking.getWeight(), booking.getBookingStatus());
	}

}

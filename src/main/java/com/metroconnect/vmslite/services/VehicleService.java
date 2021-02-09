package com.metroconnect.vmslite.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metroconnect.vmslite.dto.VehicleDto;
import com.metroconnect.vmslite.model.Vehicle;
import com.metroconnect.vmslite.repository.VehicleRepository;
import com.metroconnect.vmslite.utils.VehicleMapper;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<VehicleDto> findAllVehiclesAvailable(Date pickup, String sourceCity) {
		List<Vehicle> results = vehicleRepository.findAllVehiclesAvailable(pickup, sourceCity);
		List<VehicleDto> convertedResults = new ArrayList<VehicleDto>();
		for (Vehicle result : results) {
			convertedResults.add(VehicleMapper.toVechileDto(result));
		}
		return convertedResults;
	}

	public VehicleDto updateAvailability(Date pickup, VehicleDto vehicle, int offset) {
		Vehicle toUpdateVehicle = VehicleMapper.toVehicleEntity(vehicle);
		Date availability = pickup;
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(availability); 
		cal.add(Calendar.DATE, offset);
		availability = cal.getTime();
		toUpdateVehicle.setAvailability(availability);
		return VehicleMapper.toVechileDto(vehicleRepository.save(toUpdateVehicle));
	}

}

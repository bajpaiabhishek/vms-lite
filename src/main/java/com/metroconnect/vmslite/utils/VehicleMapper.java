package com.metroconnect.vmslite.utils;

import com.metroconnect.vmslite.dto.VehicleDto;
import com.metroconnect.vmslite.model.Vehicle;

public class VehicleMapper {
	
	public static VehicleDto toVechileDto(Vehicle vehicle) {
		return new VehicleDto(vehicle.getVehicleNumber(), vehicle.getSourceMetro(), vehicle.getAvailability());
	}
	
	public static Vehicle toVehicleEntity(VehicleDto vehicle) {
		return new Vehicle(vehicle.getVehicleNumber(), vehicle.getSourceMetro(), vehicle.getAvailability());
	}
}

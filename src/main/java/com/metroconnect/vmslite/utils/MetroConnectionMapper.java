package com.metroconnect.vmslite.utils;

import com.metroconnect.vmslite.dto.MetroConnectionDto;
import com.metroconnect.vmslite.model.MetroConnection;

public class MetroConnectionMapper {
	
	public static MetroConnectionDto toMetroConnectionDto(MetroConnection metroConnection) {

		return new MetroConnectionDto(metroConnection.getId(), metroConnection.getSourceCity(), metroConnection.getDestinationCity(), 
				metroConnection.getCost(), metroConnection.getTravelDays());
	}

	public static MetroConnection toMetroConnectionEntity(MetroConnectionDto metroConnection) {

		return new MetroConnection(metroConnection.getId(), metroConnection.getSourceCity(), metroConnection.getDestinationCity(), 
				metroConnection.getCost(), metroConnection.getTravelDays());
	}
}

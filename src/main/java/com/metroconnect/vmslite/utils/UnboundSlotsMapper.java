package com.metroconnect.vmslite.utils;

import com.metroconnect.vmslite.dto.UnboundSlotsDto;
import com.metroconnect.vmslite.model.UnboundSlots;

public class UnboundSlotsMapper {

	public static UnboundSlotsDto toUnboundSlotsDto(UnboundSlots unboundSlots) {

		return new UnboundSlotsDto(unboundSlots.getId(), unboundSlots.getStartDate(), unboundSlots.getEndDate(),
				unboundSlots.getVehicleNumber(), unboundSlots.getSourceMetro());
	}

	public static UnboundSlots toUnboundSlotsEntity(UnboundSlotsDto unboundSlots) {

		return new UnboundSlots(unboundSlots.getId(), unboundSlots.getStartDate(), unboundSlots.getEndDate(),
				unboundSlots.getVehicleNumber(), unboundSlots.getSourceMetro());
	}

}

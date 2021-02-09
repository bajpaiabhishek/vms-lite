package com.metroconnect.vmslite.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metroconnect.vmslite.dto.UnboundSlotsDto;
import com.metroconnect.vmslite.model.UnboundSlots;
import com.metroconnect.vmslite.repository.UnboundSlotsRepository;
import com.metroconnect.vmslite.utils.UnboundSlotsMapper;

@Service
public class UnboundSlotsService {

	@Autowired
	private UnboundSlotsRepository unboundSlotsRepo;

	public UnboundSlotsDto save(UnboundSlotsDto unboundSlot) {
		return UnboundSlotsMapper
				.toUnboundSlotsDto(unboundSlotsRepo.save(UnboundSlotsMapper.toUnboundSlotsEntity(unboundSlot)));
	}

	public List<UnboundSlotsDto> findAllVehiclesAvailable(Date pickup, Date delivery, String sourceCity) {
		List<UnboundSlots> results = unboundSlotsRepo.findAllVehiclesAvailable(pickup, delivery, sourceCity);
		List<UnboundSlotsDto> convertedResults = new ArrayList<UnboundSlotsDto>();
		for (UnboundSlots result : results) {
			convertedResults.add(UnboundSlotsMapper.toUnboundSlotsDto(result));
		}
		return convertedResults;
	}

	public void remove(UnboundSlotsDto unboundSlot) {
		unboundSlotsRepo.delete(UnboundSlotsMapper.toUnboundSlotsEntity(unboundSlot));
	}

}

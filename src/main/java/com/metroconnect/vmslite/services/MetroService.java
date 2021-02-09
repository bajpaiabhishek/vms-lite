package com.metroconnect.vmslite.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metroconnect.vmslite.repository.MetroConnectionRepository;

@Service
public class MetroService {

	@Autowired
	private MetroConnectionRepository metroRepo;

	public int getTravelDays(String source, String destination) {
		return metroRepo.getTravelDays(source, destination);
	}

	public int getCost(String source, String destination) {
		return metroRepo.getCost(source, destination);
	}

	public Set<String> getAllSourceCities() {
		return metroRepo.getAllSourceCities();
	}

	public Set<String> getAllDestinationCities() {
		return metroRepo.getAllDestinationCities();
	}
}

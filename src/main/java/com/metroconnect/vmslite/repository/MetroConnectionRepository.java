package com.metroconnect.vmslite.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metroconnect.vmslite.model.MetroConnection;

public interface MetroConnectionRepository extends JpaRepository<MetroConnection, Long> {

	@Query("SELECT m.travelDays from MetroConnection m where m.sourceCity = ?1 and m.destinationCity = ?2")
	int getTravelDays(String source, String destination);

	@Query("SELECT m.cost from MetroConnection m where m.sourceCity = ?1 and m.destinationCity = ?2")
	int getCost(String source, String destination);

	@Query("SELECT DISTINCT m.sourceCity from MetroConnection m")
	Set<String> getAllSourceCities();

	@Query("SELECT DISTINCT m.sourceCity from MetroConnection m")
	Set<String> getAllDestinationCities();

}

package com.metroconnect.vmslite.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metroconnect.vmslite.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	@Query(value = "SELECT v from Vehicle v where v.availability <= ?1 and v.sourceMetro = ?2")
	List<Vehicle> findAllVehiclesAvailable(Date pickup, String sourceCity);

}

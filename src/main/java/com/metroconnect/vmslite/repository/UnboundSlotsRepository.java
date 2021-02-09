package com.metroconnect.vmslite.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.metroconnect.vmslite.model.UnboundSlots;

public interface UnboundSlotsRepository extends JpaRepository<UnboundSlots, Long> {

	@Query(value = "SELECT v from UnboundSlots v where ?1 BETWEEN v.startDate and v.endDate and ?2 BETWEEN v.startDate and v.endDate and v.sourceMetro = ?3")
	List<UnboundSlots> findAllVehiclesAvailable(Date pickup, Date delivery, String sourceCity);
}

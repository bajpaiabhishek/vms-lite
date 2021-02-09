package com.metroconnect.vmslite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metroconnect.vmslite.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}

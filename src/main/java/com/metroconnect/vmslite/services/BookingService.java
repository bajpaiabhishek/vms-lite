package com.metroconnect.vmslite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metroconnect.vmslite.dto.BookingDto;
import com.metroconnect.vmslite.repository.BookingRepository;
import com.metroconnect.vmslite.utils.BookingMapper;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public BookingDto save(BookingDto newBooking) {
		return BookingMapper.toBookingDto(bookingRepository.save(BookingMapper.toBookingEntity(newBooking)));
	}

}

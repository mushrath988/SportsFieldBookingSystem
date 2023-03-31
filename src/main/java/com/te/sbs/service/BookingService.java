package com.te.sbs.service;

import com.te.sbs.dto.BookingDto;

public interface BookingService {

	Integer booking(BookingDto bookingDto, Integer userId, Integer sportsFieldId);

}

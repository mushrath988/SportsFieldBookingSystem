package com.te.sbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {
	private Integer userId;
	private Integer sportsFieldId;
	private String bookingDate;
	private PaymentDto paymentDto;
	private TimeSlotDto timeSlot;
}

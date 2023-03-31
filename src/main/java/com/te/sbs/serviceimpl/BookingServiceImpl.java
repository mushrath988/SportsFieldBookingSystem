package com.te.sbs.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.BookingDto;
import com.te.sbs.entity.Booking;
import com.te.sbs.entity.BookingStatus;
import com.te.sbs.entity.Payment;
import com.te.sbs.entity.SportsField;
import com.te.sbs.entity.TimeSlot;
import com.te.sbs.entity.User;
import com.te.sbs.repository.BookingRepository;
import com.te.sbs.repository.BookingStatusRepository;
import com.te.sbs.repository.PaymentRepository;
import com.te.sbs.repository.SportsFieldRepository;
import com.te.sbs.repository.TimeSlotRepository;
import com.te.sbs.repository.UserRepository;
import com.te.sbs.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TimeSlotRepository timeSlotRepository;
	@Autowired
	private SportsFieldRepository sportsFieldRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private BookingStatusRepository bookingStatusRepository;

	@Override
	public Integer booking(BookingDto bookingDto, Integer userId, Integer sportsFieldId) {
		Booking booking = new Booking();

		List<Booking> bookingList = bookingRepository.findBybookingDate(bookingDto.getBookingDate());
		boolean startTime = false;

		if (bookingList.isEmpty()) {
			User user = userRepository.findById(userId).get();
			SportsField field = sportsFieldRepository.findById(sportsFieldId).get();
			BeanUtils.copyProperties(bookingDto, booking);
			TimeSlot timeSlot = new TimeSlot();
			timeSlot.setStartTime(bookingDto.getTimeSlot().getStartTime());
			timeSlot.setEndTime(bookingDto.getTimeSlot().getEndTime());
			if (timeSlot != null) {
				timeSlotRepository.save(timeSlot);
			}

			Payment payment = new Payment();
			payment.setAmount(bookingDto.getPaymentDto().getAmount());
			payment.setPaymentDate(bookingDto.getPaymentDto().getPaymentDate());
			payment.setPaymentMethod(bookingDto.getPaymentDto().getPaymentMethod());
			if (payment != null) {
				paymentRepository.save(payment);
			}
			BookingStatus bookingStatus = new BookingStatus();
			bookingStatus.setStatus("Successfull");
			bookingStatusRepository.save(bookingStatus);
			booking.setStatus(bookingStatus);
			booking.setPayment(payment);
			booking.setSportsField(field);
			booking.setTimeSlot(timeSlot);
			booking.setUser(user);
			bookingRepository.save(booking);
			return booking.getBookingId();
		} else if (bookingList != null) {
			for (int i = 0; i < bookingList.size(); i++) {
				if (bookingDto.getTimeSlot().getStartTime().equals(bookingList.get(i).getTimeSlot().getStartTime())) {
					startTime = true;
				}
			}
		}
		if (startTime == false) {
			User user = userRepository.findById(userId).get();
			SportsField field = sportsFieldRepository.findById(sportsFieldId).get();
			BeanUtils.copyProperties(bookingDto, booking);
			TimeSlot timeSlot = new TimeSlot();
			BeanUtils.copyProperties(timeSlot, bookingDto.getTimeSlot());
			if (timeSlot != null) {
				timeSlotRepository.save(timeSlot);
			}
			Payment payment = new Payment();
			BeanUtils.copyProperties(payment, bookingDto.getPaymentDto());
			if (payment != null) {
				paymentRepository.save(payment);
			}
			BookingStatus bookingStatus = new BookingStatus();
			bookingStatus.setStatus("Successfull");
			bookingStatusRepository.save(bookingStatus);
			booking.setStatus(bookingStatus);
			booking.setPayment(payment);
			booking.setSportsField(field);
			booking.setTimeSlot(timeSlot);
			booking.setUser(user);
			bookingRepository.save(booking);
			return booking.getBookingId();

		}
		return booking.getBookingId();
	}

}

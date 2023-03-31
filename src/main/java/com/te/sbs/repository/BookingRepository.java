package com.te.sbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	List<Booking> findBybookingDate(String bookingDate);

}

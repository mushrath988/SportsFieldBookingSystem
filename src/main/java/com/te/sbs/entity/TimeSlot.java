package com.te.sbs.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TimeSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timeSlotId;
	@Column(name = "start_time",length=50)
	private String startTime;
	@Column(name = "end_time",length=50)
	private String endTime;
	//if we use mapped by it will act as a unidirectional, 
	//if we removed it will act as bidirectional
	@OneToMany(mappedBy = "timeSlot")
	private List<Booking> bookings;
}

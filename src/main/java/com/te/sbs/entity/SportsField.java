package com.te.sbs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class SportsField {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fieldId;
	private String fieldName;
	private String location;
	private long capacity;
	@OneToMany(mappedBy = "sportsField")
	@JsonBackReference
	private List<Booking> booking;
}

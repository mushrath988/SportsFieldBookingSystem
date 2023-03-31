package com.te.sbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	@Column(name = "amount", length = 50, nullable = false)
	private Double amount;
	@Column(name = "payment_date", length = 50, nullable = false)
	private String paymentDate;
	@Column(name = "payment_method", length = 50, nullable = false)
	private String paymentMethod;
}

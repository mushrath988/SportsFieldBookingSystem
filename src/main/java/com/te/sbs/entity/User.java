package com.te.sbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotNull(message = "username shouldn't be null")
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	@Email
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	
}

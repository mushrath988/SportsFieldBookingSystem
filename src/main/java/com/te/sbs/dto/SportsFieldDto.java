package com.te.sbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportsFieldDto {
	
	private String fieldName;
	private String location;
	private long capacity;
}

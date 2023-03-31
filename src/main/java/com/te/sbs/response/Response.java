package com.te.sbs.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class Response {
	private boolean error;
	private String message;
	private int status;
	private Object List;
	private Object data;
}

package com.te.sbs.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.UserDto;
import com.te.sbs.entity.User;
import com.te.sbs.response.Response;
import com.te.sbs.service.UserService;

@RestController
public class RegisterAndLoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private Response response;

	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody UserDto userDto) {
		UserDto userDtoAdd = userService.register(userDto);

		if (userDtoAdd != null) {
			response.setError(false);
			response.setMessage("Registered");
			response.setList(Arrays.asList(userDtoAdd));
			response.setStatus(200);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Not registered");
			response.setList(Arrays.asList(userDtoAdd));
			response.setStatus(401);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<Response> findByEmail(@RequestBody UserDto userDto) {
		User user = userService.findByEmail(userDto);
		
		if (user != null) {
			response.setError(false);
			response.setMessage("Login successful");
			response.setList(Arrays.asList(user));
			response.setStatus(200);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Invalid login");
			response.setList(Arrays.asList(user));
			response.setStatus(401);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}
}

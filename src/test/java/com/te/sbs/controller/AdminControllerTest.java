package com.te.sbs.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.te.sbs.dto.UserDto;
import com.te.sbs.entity.User;
import com.te.sbs.service.PaymentService;
import com.te.sbs.service.UserService;

@SpringBootTest
class AdminControllerTest {

	@Autowired
	private UserService userService;
	@Autowired
	PaymentService paymentService;

	@Autowired
	private MockMvc mockMvc;

	private User user;

	@BeforeEach
	public void setUp() throws Exception {
		user = new User(1, "uchiha", "uchiha@gmail.com", "Anime");
	}

	@AfterEach
	public void tearDown() throws Exception {
		user = null;
	}

	@Test
	public void testGetAllUsers() throws Exception {
		List<UserDto> userDto = Arrays.asList(new UserDto());
		when(userService.getAllUsers()).thenReturn(userDto);

		RequestBuilder request = MockMvcRequestBuilders.get("/allUsers").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk());
	}
}

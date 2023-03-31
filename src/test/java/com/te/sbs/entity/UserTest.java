package com.te.sbs.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	User user=new User(1,"Ayesha","ayesha@gmail.com","123");
	
	@Test
	void testGetUserId() {
		assertEquals(1, user.getUserId());
	}

	@Test
	void testGetname() {
		assertEquals("Ayesha", user.getName());
	}
	
	@Test
	void testGetemail() {
		assertEquals("ayesha@gmail.com", user.getEmail());
	}
	
	@Test
	void testGetpassword() {
		assertEquals("123", user.getPassword());
	}
}

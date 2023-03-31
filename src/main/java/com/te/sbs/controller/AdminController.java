package com.te.sbs.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.PaymentDto;
import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.dto.UserDto;
import com.te.sbs.entity.SportsField;
import com.te.sbs.response.Response;
import com.te.sbs.service.PaymentService;
import com.te.sbs.service.SportsFieldService;
import com.te.sbs.service.UserService;

@RestController
public class AdminController {
	@Autowired
	private SportsFieldService sportsFieldService;
	@Autowired
	private Response response;
	@Autowired
	private UserService userService;
	@Autowired
	PaymentService paymentService;

	@PostMapping("/addFields")
	public ResponseEntity<Response> addField(@RequestBody SportsFieldDto sportsFieldDto){
		SportsField sportsField=sportsFieldService.addField(sportsFieldDto);
		
		if (sportsField != null) {
			response.setError(false);
			response.setMessage("Field is added");
			response.setList(Arrays.asList(sportsField));
			response.setStatus(200);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Field is not added");
			response.setList(Arrays.asList(sportsField));
			response.setStatus(401);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}	
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<Response> getAllUsers(){
		
		List<UserDto> userDto = userService.getAllUsers();
		
		if (userDto != null) {
			response.setError(false);
			response.setMessage("All users are showned");
			response.setStatus(200);
			response.setList(Arrays.asList(userDto));
			return new ResponseEntity<>(response, HttpStatus.FOUND);
		} else {
			response.setError(true);
			response.setMessage("Oops something is wrong");
			response.setStatus(401);
			response.setList(Arrays.asList(userDto));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Response> getUserById(@PathVariable Integer id){
		UserDto userDto = userService.getUserById(id);
		if (userDto != null) {
			response.setError(false);
			response.setMessage("User is shown");
			response.setStatus(20);
			response.setList(Arrays.asList(userDto));
			return new ResponseEntity<>(response, HttpStatus.FOUND);
		} else {
			response.setError(true);
			response.setMessage("Oops something is wrong");
			response.setStatus(401);
			response.setList(Arrays.asList(userDto));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable Integer id){
		Integer Id = userService.deleteUser(id);
		if (Id != null) {
			response.setError(false);
			response.setMessage("User is Deleted");
			response.setStatus(200);
			response.setList(Arrays.asList(Id));
			return new ResponseEntity<>(response, HttpStatus.FOUND);
		} else {
			response.setError(true);
			response.setMessage("Oops something is wrong");
			response.setStatus(401);
			response.setList(Arrays.asList(Id));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/payment/{id}")
	public ResponseEntity<Response> updatePaymentInfo(@RequestBody PaymentDto paymentDto,@PathVariable Integer id){
		PaymentDto newPaymentDto = paymentService.updatePaymentInfo(paymentDto,id);
		if (newPaymentDto != null) {
			response.setError(false);
			response.setMessage("Information Updated");
			response.setStatus(200);
			response.setList(Arrays.asList(newPaymentDto));
			return new ResponseEntity<>(response, HttpStatus.FOUND);
		} else {
			response.setError(true);
			response.setMessage("Information is not updated");
			response.setStatus(401);
			response.setList(Arrays.asList(newPaymentDto));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}

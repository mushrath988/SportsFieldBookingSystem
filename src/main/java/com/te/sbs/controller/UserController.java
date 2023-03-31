package com.te.sbs.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.BookingDto;
import com.te.sbs.entity.SportsField;
import com.te.sbs.response.Response;
import com.te.sbs.service.BookingService;
import com.te.sbs.service.SportsFieldService;

@RestController
public class UserController {
	@Autowired
	private SportsFieldService sportsFieldService;
	@Autowired
	private Response response;
	@Autowired
	private BookingService bookingService;

	@GetMapping("/showFields")
	public ResponseEntity<Response> showField() {
		List<SportsField> sfList = sportsFieldService.showField();

		if (sfList != null) {
			response.setError(false);
			response.setMessage("fields are shown");
			response.setStatus(200);
			response.setList(Arrays.asList(sfList));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(false);
			response.setMessage("fields are not showned");
			response.setStatus(401);
			response.setList(Arrays.asList(sfList));
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/user/{userId}/sportsField/{sportsFieldId}/booking")
	public ResponseEntity<Response> booking(@RequestBody BookingDto bookingDto,
			@PathVariable Integer userId, @PathVariable Integer sportsFieldId) {
		Integer bookingId = bookingService.booking(bookingDto, userId, sportsFieldId);
		if (bookingId != null) {
			response.setError(false);
			response.setMessage("Booking Successfull");
			response.setStatus(200);
			response.setList(Arrays.asList(bookingId));
			return new ResponseEntity<>(response, HttpStatus.FOUND);
		} else {
			response.setError(true);
			response.setMessage("Field or date is not Available");
			response.setStatus(401);
			response.setList(Arrays.asList(bookingId));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

//	@GetMapping("/getBookinginfoUser/{id}")
//	public ResponseEntity<Response> getBookingInfo(@PathVariable Integer id){
//		GetBookingInfoForUserDto adminDto = bookingService.getBookingInfoUser(id);
//		if (adminDto != null) {
//			response.setError(false);
//			response.setMessage("Here is your booking information");
//			response.setStatus("200");
//			response.setList(Arrays.asList(adminDto));
//			return new ResponseEntity<>(response, HttpStatus.FOUND);
//		} else {
//			response.setError(true);
//			response.setMessage("Information is not present");
//			response.setStatus("401");
//			response.setList(Arrays.asList(adminDto));
//			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//		}
//	}
}

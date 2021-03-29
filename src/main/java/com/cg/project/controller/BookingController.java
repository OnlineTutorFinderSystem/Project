package com.cg.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.project.entity.Booking;
import com.cg.project.exceptions.GlobalException;
import com.cg.project.service.BookingServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingServiceImpl service;

	@GetMapping("/getBookingById/{id}")
	public Optional<Booking> getBookingById(@PathVariable("id") int id) {

		Optional<Booking> test = service.getBookingById(id);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present");
		}

		return test;
	}

	@PostMapping("/makeBooking")
	public Booking makeBooking(@RequestBody Booking booking) {
		Booking test = service.makeBooking(booking);
		if (test.getPname() == null || test.getPphone() == null || test.getSub() == null) {
			throw new GlobalException("Enter values for Parent name and phone and salary.");
		}
		return test;
	}

	@PutMapping("/updateBooking")
	public Booking updateBooking(@RequestBody Booking booking) {
		Booking test = service.updateBooking(booking);
		if (test.getBookingID() == 0 || test.getPname() == null || test.getPphone() == null || test.getSub() == null) {
			throw new GlobalException("Id not present or enter the body correctly.");
		}
		Optional<Booking> test1 = service.getBookingById(test.getBookingID());
		if (test1.isEmpty()) {
			throw new GlobalException("id is not present for updating");
		}
		return test;
	}

	@DeleteMapping("/deleteBooking/{id}")
	public void deleteBooking(@PathVariable("id") int bookingID) {
		Optional<Booking> test = service.getBookingById(bookingID);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present for deleting");
		}
		service.deleteBooking(bookingID);
	}

	@GetMapping("/getBookingByPname/{parentname}")
	public List<Booking> getBookingByPname(@PathVariable("parentname") String pname) {
		List<Booking> test = service.getBookingByPname(pname);
		if (test.isEmpty()) {
			throw new GlobalException("Parent name is not present");
		}

		return test;
	}

	@GetMapping("/getBookingBysub/{subject}")
	public List<Booking> getBookingBysub(@PathVariable("subject") String sub) {

		List<Booking> test = service.getBookingBysub(sub);
		if (test.isEmpty()) {
			throw new GlobalException("Subject is not present");
		}

		return test;
	}

	@GetMapping("/getAllBookings")
	public List<Booking> getAllBookings() {
		return service.getAllBookings();
	}

}

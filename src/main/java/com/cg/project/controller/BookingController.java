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
import com.cg.project.service.BookingServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingServiceImpl service;

	@GetMapping("/getBookingById/{bookingID}")
	public Optional<Booking> getParentById(@PathVariable("pid") int bookingID) {
		return service.getBookingById(bookingID);
	}

	@PostMapping("/makeBooking")
	public Booking makeBooking(@RequestBody Booking booking) {
		return service.makeBooking(booking);
	}

	@PutMapping("/updateBooking")
	public Booking updateBooking(@RequestBody Booking booking) {
		return service.updateBooking(booking);
	}

	@DeleteMapping("/deleteBooking/{id}")
	public void deleteBooking(@PathVariable("id") int bookingID) {
		service.deleteBooking(bookingID);
	}

	@GetMapping("/getBookingByPname/{parentname}")
	public List<Booking> getBookingByPname(@PathVariable("parentname") String pname) {
		return service.getBookingByPname(pname);
	}

	@GetMapping("/getBookingBysub/{subject}")
	public List<Booking> getBookingBysub(@PathVariable("subject") String sub) {
		return service.getBookingBysub(sub);
	}

	@GetMapping("/getAllBookings")
	public List<Booking> getAllBookings() {
		return service.getAllBookings();
	}

}

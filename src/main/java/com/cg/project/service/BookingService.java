package com.cg.project.service;

import java.util.Optional;

import com.cg.project.entity.Booking;

public interface BookingService {
	Booking makeBooking(Booking booking);

	Booking updateBooking(Booking booking);

	void deleteBooking(int bookingID);

	Optional<Booking> getBookingById(int id);

}

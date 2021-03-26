package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.Booking;
import com.cg.project.repository.BookingDao;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDao dao;

	@Override
	public Booking makeBooking(Booking booking) {

		return dao.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		return dao.save(booking);
	}

	@Override
	public void deleteBooking(int bookingID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Booking> getBookingById(int id) {
		// TODO Auto-generated method stub
		return dao.findById (id);
	}

	@Override
	public List<Booking> getBookingByPname(String pname) {
		// TODO Auto-generated method stub
		return dao.findBypname(pname);
	}

	@Override
	public List<Booking> getBookingBysub(String sub) {
		// TODO Auto-generated method stub
		return dao.findBysub(sub);
	}

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}

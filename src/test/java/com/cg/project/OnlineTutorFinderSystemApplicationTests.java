package com.cg.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.project.entity.Booking;
import com.cg.project.repository.BookingDao;
import com.cg.project.service.BookingService;

/**
 * @author sreya
 *
 */
@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {

	@MockBean
	BookingDao dao;
	@Autowired
	BookingService service;

	@Test 
	void testMakeBooking() {
		Booking booking = new Booking("dummyname", "parentdummy", "subject", "Parenthnedummy", "Tutorphonedummy",
				"grade");
		when(dao.save(booking)).thenReturn(booking);
		Booking result = service.makeBooking(booking);
		assertEquals("dummyname", result.getTname());
	}

	@Test
	void testUpdateBooking() {
		Booking booking = new Booking(1, "updateDummy", "updateParentdummy", "UpdateSubject", "updateParentPhDummy",
				"UpdateTutorphonedummy", "UpdateGrade");
		when(dao.save(booking)).thenReturn(booking);
		Booking result = service.updateBooking(booking);
		assertEquals(1, result.getBookingID());
		assertEquals("updateParentdummy", result.getPname());
	}

	@Test
	void testDeleteBooking() {
		Booking booking = new Booking(2, "updateDummy", "updateParentdummy", "UpdateSubject", "updateParentPhDummy",
				"UpdateTutorphonedummy", "UpdateGrade");
		service.deleteBooking(1);
		Optional<Booking> deletedBooking = service.getBookingById(2);
		assertEquals(Optional.empty(), deletedBooking);

	}

	@Test
	void testFindBooking() {
		Booking booking = new Booking(1, "updateDummy", "updateParentdummy", "UpdateSubject", "updateParentPhDummy",
				"UpdateTutorphonedummy", "UpdateGrade");
		when(dao.findById(1)).thenReturn(Optional.of(booking));
		Optional<Booking> result = service.getBookingById(1);
		assertTrue(result.isPresent());
	}

	@Test
	void testFindBypname() {
		Booking booking = new Booking(3, "updateDummy", "updateParentdummy", "UpdateSubject", "updateParentPhDummy",
				"UpdateTutorphonedummy", "UpdateGrade");
		List<Booking> list = new ArrayList<Booking>();
		list.add(booking);
		when(dao.findBypname("updateParentdummy")).thenReturn(list);
		List<Booking> result = service.getBookingByPname("updateParentdummy");
		assertEquals(result, list);
	}

	@Test
	void testFindBysub() {
		Booking booking = new Booking(4, "updateDummy", "updateParentdummy", "UpdateSubject", "updateParentPhDummy",
				"UpdateTutorphonedummy", "UpdateGrade");
		List<Booking> list = new ArrayList<Booking>();
		list.add(booking);
		when(dao.findAll()).thenReturn(list);
		List<Booking> result = service.getAllBookings();
		assertEquals(result, list);
	}

}

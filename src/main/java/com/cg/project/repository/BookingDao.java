package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cg.project.entity.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {

	List<Booking> getAllBookings = null;

	public List<Booking> findBypname(String pname);

	public List<Booking> findBysub(String tname);

}

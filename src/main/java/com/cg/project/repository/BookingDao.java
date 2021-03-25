package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {

}

package com.cg.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.DemoSession;

@Repository
public interface DemoSessionDao extends JpaRepository<DemoSession, Integer> {
	public List<DemoSession> findBydate(String date);
}

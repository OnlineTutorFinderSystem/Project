package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.TutorDetails;

@Repository
public interface TutorDao extends JpaRepository<TutorDetails,Integer> {
	

}

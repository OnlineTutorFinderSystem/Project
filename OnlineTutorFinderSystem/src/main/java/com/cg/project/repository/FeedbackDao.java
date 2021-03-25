package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback,Integer>   {
	

}

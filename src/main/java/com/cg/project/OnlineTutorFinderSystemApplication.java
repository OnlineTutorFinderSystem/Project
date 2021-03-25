package com.cg.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.project.repository.TutorDaoInterface;
import com.cg.project.service.TutorService;



@SpringBootApplication
class OnlineTutorFinderSystemApplication {

	
	
	@Autowired
	TutorService service;
	



}

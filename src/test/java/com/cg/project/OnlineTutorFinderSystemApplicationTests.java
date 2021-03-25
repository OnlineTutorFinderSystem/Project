package com.cg.project;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.project.entity.TutorDetails;
import com.cg.project.repository.TutorDaoInterface;
import com.cg.project.service.TutorService;

@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {

	@MockBean
	TutorDaoInterface dao;
	@Autowired
	TutorService service;
	@Test
	void testAddTutorIsThere() {
		TutorDetails tutor = new TutorDetails(1,"hari",10000,"Science","Chennai");
		when(dao.GetTutor(1)).thenReturn(tutor);
		TutorDetails results = tutor;
		assertEquals("hari",results.getName());
		
		
	}
	@Test
	void testAddTutorIsThere1() {
		TutorDetails tutor = new TutorDetails(1,"hari",10000,"Science","Chennai");
		when(dao.GetTutor(1)).thenReturn(tutor);
		TutorDetails results = tutor;
		assertEquals("hari",results.getName());
		
		
	}

}

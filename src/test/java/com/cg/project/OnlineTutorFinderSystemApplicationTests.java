package com.cg.project;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.project.entity.TutorDetails;
import com.cg.project.repository.TutorDao;
import com.cg.project.service.TutorService;
@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {

	@MockBean
	TutorDao dao;
	@Autowired
	TutorService service;
	@Test
	void testAddtutor() {
		TutorDetails tutor = new TutorDetails(1,"hari",10000,"Science","Chennai");
		when(dao.save(tutor)).thenReturn(tutor);
		TutorDetails results = service.addTutor(tutor);
		assertEquals("hari",results.getName());
		
		
	}
	
	
	/*@Test
	void testUpdateTutor() {
		TutorDetails tutor = new TutorDetails(1,"thri",10000,"Social","Chennai");
		when(dao.save(tutor)).thenReturn(tutor);
		TutorDetails results = service.updateTutor(tutor);
		assertEquals("thri",results.getName());
		
		
	}
	
@Test
void testDeleteTutor() {
	TutorDetails tutor = new TutorDetails(100,"ram",10000,"maths","Chennai");
	service.addTutor(tutor);
	service.deleteTutor(100);
	Optional<TutorDetails> deletedTutor = service.getTutor(100);
	assertEquals(Optional.empty(),deletedTutor);
	
	
}*/
/*	@Test
	void testGetTutor(){
		TutorDetails tutor = new TutorDetails(100,"ram",10000,"maths","Chennai");
		when(dao.findById(100)).thenReturn(Optional.of(tutor));
		boolean result = service.getTutor(100);
		
		
	}*/
}


package com.cg.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.project.entity.Feedback;
import com.cg.project.service.FeedbackService;

@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {

	@Autowired
	FeedbackService service;

	@Test
	public void testAddFeedback() {
		Feedback feedback = new Feedback("Raju", "Anand", 5);
		Feedback result = service.addFeedback(feedback);
		assertEquals("Raju", result.getPname());
      
	}
	@Test
	void testUpdateFeedback() {
		Feedback feedback = new Feedback("Raju", "Anand", 9);
		when(dao.save(feedback)).thenReturn(feedback);
		
	}
	@Test
	void testDeleteFeedback() {
		Feedback feedback = new Feedback("Aditya", "Yadav", 4);
		service.removefeedback(1);
		
	}
	
}

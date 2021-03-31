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

import com.cg.project.entity.Feedback;
import com.cg.project.repository.FeedbackDao;
import com.cg.project.service.FeedbackService;

@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {

	@MockBean
	FeedbackDao dao;
	@Autowired
	FeedbackService service;

	@Test
	public void testAddFeedback() {
		Feedback feedback = new Feedback("Raju", "Anand", 5);
		when(dao.save(feedback)).thenReturn(feedback);
		Feedback result = service.addFeedback(feedback);
		assertEquals("Raju", result.getPname());

	}

	@Test
	void testUpdateFeedback() {
		Feedback feedback = new Feedback(1, "UpadteGandhi", "Anand", 9);
		when(dao.save(feedback)).thenReturn(feedback);
		Feedback result = service.updateFeedback(feedback);
		assertEquals(1, result.getFid());
		assertEquals("UpadteGandhi", result.getPname());

	}

	@Test
	void testFindFeedback() {
		Feedback feedback = new Feedback(2, "andhi", "and", 9);
		when(dao.findById(2)).thenReturn(Optional.of(feedback));
		Optional<Feedback> result = service.findFeedback(2);
		assertTrue(result.isPresent());

	}

	@Test
	void testDeleteFeedback() {
		Feedback feedback = new Feedback(1, "Aditya", "Yadav", 4);
		service.deleteFeedback(1);
		Optional<Feedback> deletedFeedback = service.findFeedback(1);
		assertEquals(Optional.empty(), deletedFeedback);
	}

	@Test
	void testFindByRating() {
		Feedback feedback = new Feedback(1, "Aditya", "Yadav", 4);
		List<Feedback> list = new ArrayList<Feedback>();
		list.add(feedback);
		when(dao.findByrating(4)).thenReturn(list);
		List<Feedback> result = service.getByRating(4);
		assertEquals(result, list);

	}

}
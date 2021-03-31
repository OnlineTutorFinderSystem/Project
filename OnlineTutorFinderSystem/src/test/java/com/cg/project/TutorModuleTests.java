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

import com.cg.project.entity.TutorDetails;
import com.cg.project.repository.TutorDao;
import com.cg.project.service.TutorService;

@SpringBootTest
class TutorModuleTests {

	@MockBean
	TutorDao dao;

	@Autowired
	TutorService service;

	@Test
	void TestAddTutor() {
		TutorDetails tutor = new TutorDetails(1, "dummyname", 1000, "Science", "Chennai");
		when(dao.save(tutor)).thenReturn(tutor);
		TutorDetails result = service.addTutor(tutor);
		assertEquals("dummyname", result.getTutorName());

	}

	@Test
	void TestUpdateTutor() {
		TutorDetails tutor = new TutorDetails(1, "updatedummyname", 1000, "Science", "Chennai");
		when(dao.save(tutor)).thenReturn(tutor);
		TutorDetails result = service.updateTutor(tutor);
		assertEquals("updatedummyname", result.getTutorName());

	}

	@Test
	void TestDeleteTutor() {
		TutorDetails tutor = new TutorDetails(1, "dummyname", 1000, "Science", "Chennai");
		service.addTutor(tutor);
		service.deleteTutor(300);
		Optional<TutorDetails> deletedTutor = service.getTutor(300);
		assertEquals(Optional.empty(), deletedTutor);
	}

	@Test
	void testGetTutor() {
		TutorDetails tutor = new TutorDetails(1, "dummyname", 1000, "Science", "Chennai");
		when(dao.findById(400)).thenReturn(Optional.of(tutor));
		Optional<TutorDetails> result = service.getTutor(400);
		assertTrue(result.isPresent());
	}

	@Test
	void testFindBySubject() {
		TutorDetails tutor = new TutorDetails(200, "dummyname", 1000, "Science", "Chennai");
		List<TutorDetails> list = new ArrayList<TutorDetails>();
		list.add(tutor);
		when(dao.findBytutorSubject("Science")).thenReturn(list);
		List<TutorDetails> result = service.getTutorBySubject("Science");
		assertEquals(result, list);
	}

	@Test
	void testFindByName() {
		TutorDetails tutor = new TutorDetails(200, "dummyname", 1000, "Science", "Chennai");
		List<TutorDetails> list = new ArrayList<TutorDetails>();
		list.add(tutor);
		when(dao.findBytutorName("dummyname")).thenReturn(list);
		List<TutorDetails> result = service.getTutorByName("dummyname");
		assertEquals(result, list);
	}

	@Test
	void testFindAllTutors() {
		TutorDetails tutor = new TutorDetails(200, "dummyname", 1000, "Science", "Chennai");
		List<TutorDetails> list = new ArrayList<TutorDetails>();
		list.add(tutor);
		when(dao.findAll()).thenReturn(list);
		List<TutorDetails> result = service.getAllTutors();
		assertEquals(result, list);
	}

	@Test
	void testFindByLocality() {
		TutorDetails tutor = new TutorDetails(200, "dummyname", 1000, "Science", "Chennai");
		List<TutorDetails> list = new ArrayList<TutorDetails>();
		list.add(tutor);
		when(dao.findBytutorLocality("Chennai")).thenReturn(list);
		List<TutorDetails> result = service.getTutorByLocality("Chennai");
		assertEquals(result, list);
	}

	@Test
	void testFindBySalary() {
		TutorDetails tutor = new TutorDetails(200, "dummyname", 1000, "Science", "Chennai");
		List<TutorDetails> list = new ArrayList<TutorDetails>();
		list.add(tutor);
		when(dao.findBytutorSalary(1000)).thenReturn(list);
		List<TutorDetails> result = service.getTutorBySalary(1000);
		assertEquals(result, list);
	}

}
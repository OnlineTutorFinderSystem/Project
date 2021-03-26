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

import com.cg.project.entity.Parent;
import com.cg.project.repository.ParentDao;
import com.cg.project.service.ParentService;

@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {

	@MockBean
	ParentDao dao;

	@Autowired
	ParentService service;

	@Test
	void testAddParent() {
		Parent parent = new Parent("dummyname", "dummyname@gmail.com", "1234567898");
		when(dao.save(parent)).thenReturn(parent);
		Parent result = service.addParent(parent);
		assertEquals("dummyname", result.getParentName());
	}

	@Test
	void testUpdateParent() {
		Parent parent = new Parent(1, "updatedname", "updatename@gmail.com", "1234567895");
		when(dao.save(parent)).thenReturn(parent);
		Parent result = service.updateParent(parent);
		assertEquals(1, result.getParentId());
		assertEquals("updatedname", result.getParentName());
	}

	@Test
	void testDeleteParent() {
		Parent parent = new Parent(300, "dummyname", "dummyemail", "1234567894");
		service.addParent(parent);
		service.deleteParent(300);
		Optional<Parent> deletedParent = service.getParentById(300);
		assertEquals(Optional.empty(), deletedParent);
	}

	@Test
	void testFindParent() {
		Parent parent = new Parent(400, "dummyname", "dummyemail", "1234567892");
		when(dao.findById(400)).thenReturn(Optional.of(parent));
		Optional<Parent> result = service.getParentById(400);
		assertTrue(result.isPresent());
	}

	@Test
	void testFindByEmail() {
		Parent parent = new Parent(100, "dummyname", "dummyemail", "123456789");
		List<Parent> list = new ArrayList<Parent>();
		list.add(parent);
		when(dao.findByparentEmail("dummyemail")).thenReturn(list);
		List<Parent> result = service.getParentByEmail("dummyemail");
		assertEquals(result, list);
	}

	@Test
	void testFindByPhone() {
		Parent parent = new Parent(200, "dummyname", "dummyemail", "1234567890");
		List<Parent> list = new ArrayList<Parent>();
		list.add(parent);
		when(dao.findByparentPhone("1234567890")).thenReturn(list);
		List<Parent> result = service.getParentByPhone("1234567890");
		assertEquals(result, list);
	}

	@Test
	void testFindAllParents() {
		Parent parent = new Parent(200, "dummyname", "dummyemail", "1234567890");
		List<Parent> list = new ArrayList<Parent>();
		list.add(parent);
		when(dao.findAll()).thenReturn(list);
		List<Parent> result = service.getAllParents();
		assertEquals(result, list);
	}

}

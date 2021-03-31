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

import com.cg.project.entity.DemoSession;
import com.cg.project.repository.DemoSessionDao;
import com.cg.project.service.DemoSessionService;

@SpringBootTest
class DemoSessionModuleTests {

	@MockBean
	DemoSessionDao dao;

	@Autowired
	DemoSessionService service;

	@Test
	void testAddSession() {
		DemoSession session = new DemoSession("dummyname", "dummyname", "29th march", "800");
		when(dao.save(session)).thenReturn(session);
		DemoSession result = service.addSession(session);
		assertEquals("dummyname", result.getParentName());
	}

	@Test
	void testUpdateDemoSession() {
		DemoSession session = new DemoSession(1, "dummyname", "dummyname", "29th march", "800");
		when(dao.save(session)).thenReturn(session);
		DemoSession result = service.updateSession(session);
		assertEquals(1, result.getSessionId());
		assertEquals("dummyname", result.getParentName());
	}

	@Test
	void testDeleteDemoSession() {
		DemoSession session = new DemoSession(300, "dummyname", "dummyname", "29th march", "800");
		service.addSession(session);
		service.deleteSession(300);
		Optional<DemoSession> deletedDemoSession = service.getSessionById(300);
		assertEquals(Optional.empty(), deletedDemoSession);
	}

	@Test
	void testFindDemoSession() {
		DemoSession session = new DemoSession(400, "dummyname", "dummyname", "29th march", "800");
		when(dao.findById(400)).thenReturn(Optional.of(session));
		Optional<DemoSession> result = service.getSessionById(400);
		assertTrue(result.isPresent());
	}

	@Test
	void testFindAllSessions() {
		DemoSession session = new DemoSession(300, "dummyname", "dummyname", "29th march", "800");
		List<DemoSession> list = new ArrayList<DemoSession>();
		list.add(session);
		when(dao.findAll()).thenReturn(list);
		List<DemoSession> result = service.getAllSessions();
		assertEquals(result, list);
	}

}

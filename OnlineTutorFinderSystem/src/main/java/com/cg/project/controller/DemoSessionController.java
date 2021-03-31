package com.cg.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.project.entity.DemoSession;
import com.cg.project.exceptions.GlobalException;
import com.cg.project.service.DemoSessionServiceImpl;

@RestController
@RequestMapping("/session")
public class DemoSessionController {

	@Autowired
	DemoSessionServiceImpl service;

	@GetMapping("/getSessionById/{sid}")
	public Optional<DemoSession> getParentById(@PathVariable("sid") int sessionId) {
		Optional<DemoSession> test = service.getSessionById(sessionId);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present");
		}

		return test;
	}

	@PostMapping("/addSession")
	public DemoSession addSession(@RequestBody DemoSession session) {
		DemoSession test = service.addSession(session);
		if (test.getParentName() == null) {
			throw new GlobalException("Enter values for body correctly");
		}
		return test;
	}

	@PutMapping("/updateSession")
	public DemoSession updateParent(@RequestBody DemoSession session) {
		DemoSession test = service.updateSession(session);
		if (test.getSessionId() == 0) {
			throw new GlobalException("Id not present.");
		}
		return test;
	}

	@DeleteMapping("/deleteSession/{sid}")
	public void deleteParent(@PathVariable("sid") int sessionId) {
		Optional<DemoSession> test = service.getSessionById(sessionId);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present for deleting");
		}
		service.deleteSession(sessionId);
	}

	@GetMapping("/getAllSessions")
	public List<DemoSession> getAllSessions() {
		List<DemoSession> test = service.getAllSessions();
		if (test.isEmpty()) {
			throw new GlobalException("Table is empty.");
		}
		return test;
	}

	@GetMapping("/getSessionByDate/{date}")
	public List<DemoSession> getSessionByDate(@PathVariable("date") String date) {
		List<DemoSession> test = service.getByDate(date);
		if (test.isEmpty()) {
			throw new GlobalException("Email is not present");
		}
		return test;
	}

}

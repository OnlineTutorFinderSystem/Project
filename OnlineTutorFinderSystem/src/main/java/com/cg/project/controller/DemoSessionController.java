package com.cg.project.controller;

import java.util.Optional;

import org.hibernate.annotations.Parent;
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
import com.cg.project.service.DemoSessionServiceImpl;

@RestController
@RequestMapping("/session")
public class DemoSessionController {

	@Autowired
	DemoSessionServiceImpl service;

	@GetMapping("/getSessionById/{sid}")
	public Optional<DemoSession> getParentById(@PathVariable("sid") int sessionId) {
		return service.getSessionById(sessionId);
	}

	@PostMapping("/addSession")
	public DemoSession addSession(@RequestBody DemoSession session) {
		return service.addSession(session);
	}

	@PutMapping("/updateSession")
	public DemoSession updateParent(@RequestBody DemoSession session) {
		return service.updateSession(session);
	}

	@DeleteMapping("/deleteSession/{sid}")
	public void deleteParent(@PathVariable("sid") int sessionId) {
		service.deleteSession(sessionId);
	}

}

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

import com.cg.project.entity.Parent;
import com.cg.project.service.ParentServiceImpl;

@RestController
@RequestMapping("/parent")
public class ParentController {

	@Autowired
	ParentServiceImpl service;

	@GetMapping("/getParentById/{pid}")
	public Optional<Parent> getParentById(@PathVariable("pid") int parentId) {
		return service.getParentById(parentId);
	}

	@PostMapping("/addParent")
	public Parent addParent(@RequestBody Parent parent) {
		return service.addParent(parent);
	}

	@PutMapping("/updateParent")
	public Parent updateParent(@RequestBody Parent parent) {
		return service.updateParent(parent);
	}

	@DeleteMapping("/deleteParent/{pid}")
	public void deleteParent(@PathVariable("pid") int parentId) {
		service.deleteParent(parentId);
	}

	@GetMapping("/getParentByEmail/{pmail}")
	public List<Parent> getParentByEmail(@PathVariable("pmail") String parentEmail) {
		return service.getParentByEmail(parentEmail);
	}

	@GetMapping("/getParentByPhone/{pnumber}")
	public List<Parent> getParentByPhone(@PathVariable("pnumber") String parentPhone) {
		return service.getParentByPhone(parentPhone);
	}

	@GetMapping("/getAllParents")
	public List<Parent> getAllParents() {
		return service.getAllParents();
	}

}

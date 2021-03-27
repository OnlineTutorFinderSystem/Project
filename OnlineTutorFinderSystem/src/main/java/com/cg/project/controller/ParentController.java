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
import com.cg.project.exceptions.GlobalException;
import com.cg.project.service.ParentServiceImpl;

@RestController
@RequestMapping("/parent")
public class ParentController {

	@Autowired
	ParentServiceImpl service;

	@GetMapping("/getParentById/{pid}")
	public Optional<Parent> getParentById(@PathVariable("pid") int parentId) {
		Optional<Parent> test = service.getParentById(parentId);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present");
		}

		return test;
	}

	@PostMapping("/addParent")
	public Parent addParent(@RequestBody Parent parent) {
		Parent test = service.addParent(parent);
		if (test.getParentName() == null || test.getParentPhone() == null || test.getParentEmail() == null
				|| test.getParentPhone().length() != 10) {
			throw new GlobalException("Enter values for body correctly or check the phone no");
		}
		return test;
	}

	@PutMapping("/updateParent")
	public Parent updateParent(@RequestBody Parent parent) {
		Parent test = service.updateParent(parent);
		if (test.getParentId() == 0 || test.getParentName() == null || test.getParentPhone() == null
				|| test.getParentEmail() == null) {
			throw new GlobalException("Id not present or enter the body correctly.");
		}
		Optional<Parent> test1 = service.getParentById(test.getParentId());
		if (test1.isEmpty()) {
			throw new GlobalException("id is not present for updating");
		}
		return test;
	}

	@DeleteMapping("/deleteParent/{pid}")
	public void deleteParent(@PathVariable("pid") int parentId) {
		Optional<Parent> test = service.getParentById(parentId);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present for deleting");
		}
		service.deleteParent(parentId);
	}

	@GetMapping("/getParentByEmail/{pmail}")
	public List<Parent> getParentByEmail(@PathVariable("pmail") String parentEmail) {
		List<Parent> test = service.getParentByEmail(parentEmail);
		if (test.isEmpty()) {
			throw new GlobalException("Email is not present");
		}
		return test;
	}

	@GetMapping("/getParentByPhone/{pnumber}")
	public List<Parent> getParentByPhone(@PathVariable("pnumber") String parentPhone) {
		List<Parent> test = service.getParentByPhone(parentPhone);
		if (test.isEmpty()) {
			throw new GlobalException("Phone number not present");
		}
		return test;
	}

	@GetMapping("/getAllParents")
	public List<Parent> getAllParents() {
		List<Parent> test = service.getAllParents();
		if (test.isEmpty()) {
			throw new GlobalException("Table is empty.");
		}
		return test;
	}

}

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
import com.cg.project.entity.EBook;
import com.cg.project.entity.Parent;
import com.cg.project.entity.TutorDetails;
import com.cg.project.exceptions.GlobalException;
import com.cg.project.repository.TutorDao;
import com.cg.project.service.DemoSessionServiceImpl;
import com.cg.project.service.EBookServiceImpl;
import com.cg.project.service.ParentServiceImpl;
import com.cg.project.service.TutorService;

/**
 * @author VLH
 *
 */
@RestController
@RequestMapping("/Tutor")
public class TutorController {

	@Autowired
	DemoSessionServiceImpl demoService;
	@Autowired
	EBookServiceImpl ebookService;
	@Autowired
	ParentServiceImpl parentService;
	@Autowired
	TutorDao dao;
	@Autowired
	TutorService service;

	/**
	 * Add Tutor
	 * 
	 * @param tutor
	 * @return
	 */

	@PostMapping("/addTutor")
	public TutorDetails createTutor(@RequestBody TutorDetails tutor) {
		TutorDetails test = service.addTutor(tutor);
		if (test.getTutorName() == null || test.getTutorSalary() == 0 || test.getTutorSubject() == null
				|| test.getTutorLocality() == null) {
			throw new GlobalException("Enter values for body correctly ");
		}
		return test;

	}

	/**
	 * Get Tutor
	 * 
	 * @param tutorId
	 * @return
	 */
	@GetMapping("/getTutor/{id}")
	public Optional<TutorDetails> getTutorById(@PathVariable("id") int tutorId) {
		Optional<TutorDetails> test = service.getTutor(tutorId);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present");
		}
		return test;

	}

	/**
	 * Update Tutor
	 * 
	 * @param tutor
	 * @return
	 */
	@PutMapping("/updateTutor")
	public TutorDetails updateTutor(@RequestBody TutorDetails tutor) {
		TutorDetails test1 = service.updateTutor(tutor);
		if (test1.getTutorId() == 0 || test1.getTutorName() == null || test1.getTutorSalary() == 0
				|| test1.getTutorLocality() == null) {
			throw new GlobalException("Enter values for id, name ,salary and Address Correctly.");
		}
		Optional<TutorDetails> test3 = service.getTutor(tutor.getTutorId());
		if (test3.isEmpty()) {
			throw new GlobalException("id is not present for updating");
		}
		return test1;
	}

	/**
	 * Delete Tutor
	 * 
	 * @param tid
	 */
	@DeleteMapping("/deleteTutor/{id}")
	public void deleteEmployee(@PathVariable("tutorID") int tid) {
		Optional<TutorDetails> test2 = service.getTutor(tid);
		if (test2.isEmpty()) {
			throw new GlobalException("id is not present for deleting");
		}
		service.deleteTutor(tid);
	}

	/**
	 * Get All Tutor
	 * 
	 * @return
	 */

	@GetMapping("/getAllTutors")
	public List<TutorDetails> getAllTutors() {
		List<TutorDetails> test = service.getAllTutors();
		if (test.isEmpty()) {
			throw new GlobalException("Table is empty.");
		}
		return test;
	}

	/**
	 * Get Tutor By Subject
	 * 
	 * @param tutorSubject
	 * @return tutor
	 */
	// Get tutor based on Subject
	@GetMapping("/getTutorSub/{tutorSubject}")
	public List<TutorDetails> getTutorBySubject(@PathVariable("tutorSubject") String tutorSubject) {
		List<TutorDetails> test = service.getTutorBySubject(tutorSubject);
		if (test.isEmpty()) {
			throw new GlobalException("Tutor  is not present with that subject");
		}
		return test;
	}

	// Get tutor based on Name
	@GetMapping("/getTutorname/{tutorName}")
	public List<TutorDetails> getTutorByName(@PathVariable("tutorName") String tutorName) {
		List<TutorDetails> test = service.getTutorByName(tutorName);
		if (test.isEmpty()) {
			throw new GlobalException("Tutor  is not present with that name");
		}

		return test;
	}

	/**
	 * Get Tutor by Locality
	 * 
	 * @param tutorLocality
	 * @return
	 */
	@GetMapping("/getTutorlocality/{tutorLocality}")
	public List<TutorDetails> getTutorByLocality(@PathVariable("tutorLocality") String tutorLocality) {
		List<TutorDetails> test = service.getTutorByLocality(tutorLocality);
		if (test.isEmpty()) {
			throw new GlobalException("Tutor  is not present in that Locality");
		}

		return test;
	}

	/**
	 * Get Tutor By Salary
	 * 
	 * @param tutorSalary
	 * @return
	 */
	@GetMapping("/getTutorsalary/{tutorSalary}")
	public List<TutorDetails> getTutorBySalary(@PathVariable("tutorSalary") int tutorSalary) {
		List<TutorDetails> test = service.getTutorBySalary(tutorSalary);
		if (test.isEmpty()) {
			throw new GlobalException("Tutor  is not present with that Salary");
		}

		return test;
	}

	@GetMapping("/getAllEBook")
	public List<EBook> fetchAllEBook() {
		List<EBook> test = ebookService.getAllEBook();
		if (test.isEmpty())

		{
			throw new GlobalException("table is empty");
		}
		return test;
	}

	@GetMapping("/getAllParents")
	public List<Parent> getAllParents() {
		List<Parent> test = parentService.getAllParents();
		if (test.isEmpty()) {
			throw new GlobalException("Table is empty.");
		}
		return test;
	}

	@GetMapping("/getAllSessions")
	public List<DemoSession> getAllSessions() {
		List<DemoSession> test = demoService.getAllSessions();
		if (test.isEmpty()) {
			throw new GlobalException("Table is empty.");
		}
		return test;
	}
}
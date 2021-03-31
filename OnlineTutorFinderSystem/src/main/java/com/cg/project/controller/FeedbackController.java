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

import com.cg.project.entity.Feedback;
import com.cg.project.exceptions.GlobalException;
import com.cg.project.service.FeedbackServiceImpl;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackServiceImpl service;

	@GetMapping("/getFeedbackById/{fid}")
	public Optional<Feedback> getFeedbackById(@PathVariable("fid") int fid) {
		Optional<Feedback> test = service.findFeedback(fid);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present");
		}
		return test;
	}

	@PostMapping("/addFeedback")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		Feedback test = service.addFeedback(feedback);
		if (test.getPname() == null || test.getTname() == null || test.getRating() == 0 || test.getFid() == 0) {
			throw new GlobalException("Fill data corrctly");
		}

		return test;
	}

	@PutMapping("/updateFeedback")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		Feedback test = service.updateFeedback(feedback);
		if (test.getFid() == 0 || test.getPname() == null || test.getTname() == null || test.getRating() == 0) {
			throw new GlobalException("id is not presnt for update");
		}
		return test;
	}

	@DeleteMapping("/deleteFeedback/{fid}")
	public void deleteFeedback(@PathVariable("fid") int fid) {

		Optional<Feedback> test = service.findFeedback(fid);
		if (test.isEmpty()) {
			throw new GlobalException("Id is not present");
		}
		service.deleteFeedback(fid);
	}

	@GetMapping("/getFeedbackByRating/{rating}")
	List<Feedback> getByRating(@PathVariable("rating") int rating) {
		List<Feedback> test = service.getByRating(rating);
		if (test.isEmpty()) {
			throw new GlobalException("Id is not present");
		}

		return test;
	}

}
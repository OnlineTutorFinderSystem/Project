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
import com.cg.project.service.FeedbackServiceImpl;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackServiceImpl service;

	@GetMapping("/getFeedbackById/{fid}")
	public Optional<Feedback> getFeedbackById(@PathVariable("fid") int fid) {
		return service.findFeedback(fid);
	}

	@PostMapping("/addFeedback")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		return service.addFeedback(feedback);
	}

	@PutMapping("/updateFeedback")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		return service.updateFeedback(feedback);
	}

	@DeleteMapping("/deleteFeedback/{fid}")
	public void deleteFeedback(@PathVariable("fid") int fid) {
		service.deleteFeedback(fid);
	}
	@GetMapping("/getFeedbackByRating/{rating}")
	List<Feedback> getByRating(@PathVariable("rating") int rating){
		return service.getByRating(rating);
	}
	
}
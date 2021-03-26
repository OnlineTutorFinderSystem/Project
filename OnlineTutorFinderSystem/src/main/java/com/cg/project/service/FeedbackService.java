package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.Feedback;

public interface FeedbackService {
	Feedback addFeedback(Feedback feedback);

	Feedback updateFeedback(Feedback feedback);

	Optional<Feedback> findFeedback(int fid);

	void deleteFeedback(int fid);
	
	List<Feedback> getByRating(int rating);


}

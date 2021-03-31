package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.Feedback;
import com.cg.project.repository.FeedbackDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDao dao;

	@Override
	public Feedback addFeedback(Feedback feedback) {

		return dao.save(feedback);

	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return dao.save(feedback);
	}

	@Override
	public Optional<Feedback> findFeedback(int fid) {
		// TODO Auto-generated method stub
		return dao.findById(fid);
	}

	@Override
	public void deleteFeedback(int fid) {
		// TODO Auto-generated method stub
		dao.deleteById(fid);
	}

	@Override
	public List<Feedback> getByRating(int rating) {
		// TODO Auto-generated method stub
		return dao.findByrating(rating);
	}
}
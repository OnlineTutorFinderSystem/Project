package com.cg.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.TutorDetails;
import com.cg.project.repository.TutorDao;

@Service
public class TutorServiceImpl implements TutorService{
	@Autowired
	TutorDao dao;
	@Override
	public TutorDetails addTutor(TutorDetails tutor) {
		
		// TODO Auto-generated method stub
		return dao.save(tutor);
	}
	@Override
	public TutorDetails updateTutor(TutorDetails tutor) {
		// TODO Auto-generated method stub
		return dao.save(tutor);
	}
	@Override
	public void deleteTutor(int tid) {
		// TODO Auto-generated method stub
		dao.deleteById(tid);
	}
	@Override
	public Optional<TutorDetails> getTutor(int tid) {
		// TODO Auto-generated method stub
		return dao.findById(tid);
	}

	
	
}

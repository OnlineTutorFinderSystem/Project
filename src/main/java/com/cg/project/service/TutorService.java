package com.cg.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.TutorDetails;
import com.cg.project.repository.TutorDaoInterface;
@Service
public class TutorService implements TutorServiceInterface{
     @Autowired
	TutorDaoInterface tutorRepo;
	@Override
	public void AddTutor(TutorDetails tutor) {
		tutorRepo.AddTutor(tutor);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Updatetutor(TutorDetails tutor) {
		tutorRepo.Updatetutor(tutor);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deletetutor(int tid) {
		// TODO Auto-generated method stub
		tutorRepo.Deletetutor(tid);
	}

	@Override
	public TutorDetails GetTutor(int tid) {
		return tutorRepo.GetTutor(tid);
	}


}

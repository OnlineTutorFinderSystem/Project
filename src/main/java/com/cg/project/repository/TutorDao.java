package com.cg.project.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.cg.project.entity.TutorDetails;

@Repository

public class TutorDao implements TutorDaoInterface{
	HashMap<Integer, TutorDetails> Tutor = new HashMap<Integer, TutorDetails>();
	@Override

	public void AddTutor(TutorDetails tutor) {
		Tutor.put(tutor.getId(),tutor);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Updatetutor(TutorDetails tutor) {
		// TODO Auto-generated method stub
		Tutor.put(tutor.getId(),tutor);
	}

	@Override
	public void Deletetutor(int tid) {
		// TODO Auto-generated method stub
		Tutor.remove(tid);
		
	}

	@Override
	
	public TutorDetails GetTutor(int tid) {
		// TODO Auto-generated method stub
		
		return Tutor.get(tid);
		
	}
	
	
	
	
}
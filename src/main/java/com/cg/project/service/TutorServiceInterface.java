package com.cg.project.service;

import com.cg.project.entity.TutorDetails;

public interface TutorServiceInterface {
	void AddTutor(TutorDetails tutor);
	void Updatetutor(TutorDetails tutor);
	void Deletetutor(int tid);
	TutorDetails GetTutor(int tid);
	

}

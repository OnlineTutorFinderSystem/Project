package com.cg.project.repository;

import com.cg.project.entity.TutorDetails;

public interface TutorDaoInterface {
	void Updatetutor(TutorDetails tutor);
	void Deletetutor(int tid);
	TutorDetails  GetTutor(int tid);
	void AddTutor(TutorDetails tutor);
	

}

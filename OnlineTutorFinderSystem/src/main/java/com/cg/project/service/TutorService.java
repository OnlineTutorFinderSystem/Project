package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.TutorDetails;

public interface TutorService {

	TutorDetails addTutor(TutorDetails tutor);

	TutorDetails updateTutor(TutorDetails tutor);

	void deleteTutor(int tid);

	Optional<TutorDetails> getTutor(int tid);

	List<TutorDetails> getTutorBySubject(String subject);

	List<TutorDetails> getAllTutors();

	List<TutorDetails> getTutorByName(String name);

	List<TutorDetails> getTutorByLocality(String locality);

	List<TutorDetails> getTutorBySalary(int salary);
}
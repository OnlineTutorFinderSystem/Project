package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.TutorDetails;
import com.cg.project.repository.TutorDao;

@Service
public class TutorServiceImpl implements TutorService {
	@Autowired
	TutorDao dao;

	@Override
	public TutorDetails addTutor(TutorDetails tutor) {

		return dao.save(tutor);
	}

	@Override
	public TutorDetails updateTutor(TutorDetails tutor) {

		return dao.save(tutor);
	}

	@Override
	public void deleteTutor(int tid) {

		dao.deleteById(tid);
	}

	@Override
	public Optional<TutorDetails> getTutor(int tid) {

		return dao.findById(tid);
	}

	@Override
	public List<TutorDetails> getTutorBySubject(String subject) {

		return dao.findBytutorSubject(subject);
	}

	@Override
	public List<TutorDetails> getTutorByName(String name) {
		return dao.findBytutorName(name);
	}

	@Override
	public List<TutorDetails> getAllTutors() {

		return dao.findAll();
	}

	@Override
	public List<TutorDetails> getTutorByLocality(String locality) {

		return dao.findBytutorLocality(locality);
	}

	@Override
	public List<TutorDetails> getTutorBySalary(int salary) {

		return dao.findBytutorSalary(salary);
	}

}
package com.cg.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.TutorDetails;

/**
 * @author VLH
 *
 */
@Repository
public interface TutorDao extends JpaRepository<TutorDetails, Integer> {

	List<TutorDetails> findBytutorSubject(String subject);

	List<TutorDetails> findBytutorName(String name);

	List<TutorDetails> findBytutorLocality(String locality);

	List<TutorDetails> findBytutorSalary(int salary);

}
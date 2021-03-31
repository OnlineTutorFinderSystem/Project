package com.cg.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author VLH
 *
 */

@Entity
public class TutorDetails {
	@Id
	@GeneratedValue
	private int tutorId;
	private String tutorName;
	private int tutorSalary;
	private String tutorSubject;
	private String tutorLocality;
	private long tutorPhone;
	private String tutorEmail;

	public long getTutorPhone() {
		return tutorPhone;
	}

	public void setTutorPhone(long tutorPhone) {
		this.tutorPhone = tutorPhone;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public int getTutorSalary() {
		return tutorSalary;
	}

	public void setTutorSalary(int tutorSalary) {
		this.tutorSalary = tutorSalary;
	}

	public String getTutorSubject() {
		return tutorSubject;
	}

	public void setTutorSubject(String tutorSubject) {
		this.tutorSubject = tutorSubject;
	}

	public String getTutorLocality() {
		return tutorLocality;
	}

	public void setTutorLocality(String tutorLocality) {
		this.tutorLocality = tutorLocality;
	}

	public String getTutorEmail() {
		return tutorEmail;
	}

	public void setTutorEmail(String tutorEmail) {
		this.tutorEmail = tutorEmail;
	}

	public TutorDetails(int tutorId, String tutorName, int tutorSalary, String tutorSubject, String tutorLocality,
			long tutorPhone, String tutorEmail) {
		super();
		this.tutorId = tutorId;
		this.tutorName = tutorName;
		this.tutorSalary = tutorSalary;
		this.tutorSubject = tutorSubject;
		this.tutorLocality = tutorLocality;
		this.tutorPhone = tutorPhone;
		this.tutorEmail = tutorEmail;
	}

	public TutorDetails(int tutorId, String tutorName, int tutorSalary, String tutorSubject, String tutorLocality) {
		super();
		this.tutorId = tutorId;
		this.tutorName = tutorName;
		this.tutorSalary = tutorSalary;
		this.tutorSubject = tutorSubject;
		this.tutorLocality = tutorLocality;
	}

}
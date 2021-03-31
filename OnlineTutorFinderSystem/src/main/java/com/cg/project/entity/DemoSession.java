package com.cg.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DemoSession {

	@Id
	private int sessionId;
	private String parentName;
	private String TutorName;
	private String date;
	private String price;

	public DemoSession() {
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getTutorName() {
		return TutorName;
	}

	public void setTutorName(String tutorName) {
		TutorName = tutorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "DemoSession [sessionId=" + sessionId + ", parentName=" + parentName + ", TutorName=" + TutorName
				+ ", date=" + date + ", price=" + price + "]";
	}

	public DemoSession(String parentName, String tutorName, String date, String price) {
		super();
		this.parentName = parentName;
		TutorName = tutorName;
		this.date = date;
		this.price = price;
	}

	public DemoSession(int sessionId, String parentName, String tutorName, String date, String price) {
		super();
		this.sessionId = sessionId;
		this.parentName = parentName;
		TutorName = tutorName;
		this.date = date;
		this.price = price;
	}

}

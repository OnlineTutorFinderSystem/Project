package com.cg.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private int bookingID;
	private String tname;
	private String pname;
	private String sub;
	private String pphone;
	private String tphone;
	private String grade;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(int bookingID, String tname, String pname, String sub, String pphone, String tphone, String grade) {
		super();
		this.bookingID = bookingID;
		this.tname = tname;
		this.pname = pname;
		this.sub = sub;
		this.pphone = pphone;
		this.tphone = tphone;
		this.grade = grade;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		tname = tname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		pname = pname;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getPphone() {
		return pphone;
	}

	public void setPphone(String pphone) {
		pphone = pphone;
	}

	public String getTphone() {
		return tphone;
	}

	@Override
	public String toString() {
		return bookingID + " " + tname + " " + pname + " " + sub + " " + pphone + " " + tphone + " " + grade;
	}

	public void setTphone(String tphone) {
		tphone = tphone;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Booking(String tname, String pname, String sub, String pphone, String tphone, String grade) {
		super();
		this.tname = tname;
		this.pname = pname;
		this.sub = sub;
		this.pphone = pphone;
		this.tphone = tphone;
		this.grade = grade;
	}

}

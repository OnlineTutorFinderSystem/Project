package com.cg.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	@GeneratedValue
	private int fid;
	private String pname;
	private String tname;
	private int rating;

	public Feedback() {
		// TODO Auto-generated constructor stub

	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Feedback(int fid, String pname, String tname, int rating) {
		super();
		this.fid = fid;
		this.pname = pname;
		this.tname = tname;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", pname=" + pname + ", tname=" + tname + ", rating=" + rating + "]";
	}

	public Feedback(String pname, String tname, int rating) {
		super();
		this.pname = pname;
		this.tname = tname;
		this.rating = rating;
	}

}
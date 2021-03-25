package com.cg.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Ebook {
	@Id
	@GeneratedValue
	@Column(length = 10)
	private int ebookId;
	@Column(length = 20)
	private String ebookName;
	@Column(length = 20)
	private String ebookgrade;
	@Column(length = 20)
	private int tutorId;
	@Column(length = 20)
	private String tutorName;

	public int getEbookId() {
		return ebookId;
	}

	public void setEbookId(int ebookId) {
		ebookId = ebookId;
	}

	public String getEbookName() {
		return ebookName;
	}

	public void setEbookName(String ebookName) {
		ebookName = ebookName;
	}

	public String getEbookgrade() {
		return ebookgrade;
	}

	public void setEbookgrade(String ebookgrade) {
		ebookgrade = ebookgrade;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		tutorId = tutorId;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		tutorName = tutorName;
	}

	@Override
	public String toString() {
		return "ebook [ebookId=" + ebookId + ", ebookName=" + ebookName + ", ebookgrade=" + ebookgrade + ", tutorId="
				+ tutorId + ", tutorName=" + tutorName + "]";
	}

	public Ebook() {
		// TODO Auto-generated constructor stub
	}

	public Ebook(String ebookName, String ebookgrade, int tutorId, String tutorName) {
		super();
		this.ebookName = ebookName;
		this.ebookgrade = ebookgrade;
		this.tutorId = tutorId;
		this.tutorName = tutorName;
	}

	public Ebook(int ebookId, String ebookName, String ebookgrade, int tutorId, String tutorName) {
		super();
		this.ebookId = ebookId;
		this.ebookName = ebookName;
		this.ebookgrade = ebookgrade;
		this.tutorId = tutorId;
		this.tutorName = tutorName;
	}

}

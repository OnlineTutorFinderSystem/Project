package com.cg.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class EBook {
	@Id
	@GeneratedValue
	@Column(length = 10)
	private int ebookId;
	@Column(length = 20)
	private String ebookName;
	@Column(length = 20)
	private int ebookPrice;
	@Column(length = 20)
	private String ebookGrade;
	@Column(length = 20)
	private int tutorId;
	@Column(length = 20)
	private String tutorName;

	public int getEBookId() {
		return ebookId;
	}

	public void setEBookId(int ebookId) {
		this.ebookId = ebookId;
	}

	public String getEBookName() {
		return ebookName;
	}

	public void setEBookName(String ebookName) {
		this.ebookName = ebookName;
	}

	public int getEBookPrice() {
		return ebookPrice;
	}

	public void setEBookPrice(int ebookPrice) {
		this.ebookPrice = ebookPrice;
	}

	public String getEBookGrade() {
		return ebookGrade;
	}

	public void setEBookGrade(String ebookGrade) {
		this.ebookGrade = ebookGrade;
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

	public EBook(int ebookId, String ebookName, int ebookPrice, String ebookGrade, int tutorId, String tutorName) {
		super();
		this.ebookId = ebookId;
		this.ebookName = ebookName;
		this.ebookPrice = ebookPrice;
		this.ebookGrade = ebookGrade;
		this.tutorId = tutorId;
		this.tutorName = tutorName;
	}

	public EBook(String ebookName, int ebookPrice, String ebookGrade, int tutorId, String tutorName) {
		super();
		this.ebookName = ebookName;
		this.ebookPrice = ebookPrice;
		this.ebookGrade = ebookGrade;
		this.tutorId = tutorId;
		this.tutorName = tutorName;
	}

	@Override
	public String toString() {
		return "EBook [EBookId=" + ebookId + ", EBookName=" + ebookName + ", EBookPrice=" + ebookPrice + ", EBookGrade="
				+ ebookGrade + ", tutorId=" + tutorId + ", tutorName=" + tutorName + "]";
	}

	public EBook() {

	}

}

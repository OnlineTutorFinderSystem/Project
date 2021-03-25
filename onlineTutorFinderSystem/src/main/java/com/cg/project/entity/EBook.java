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
	private int EBookId;
	@Column(length = 20)
	private String EBookName;
	@Column(length =20)
	private int EBookPrice;
	@Column(length = 20)
	private String EBookGrade;
	@Column(length = 20)
	private int tutorId;
	@Column(length = 20)
	private String tutorName;
	public int getEBookId() {
		return EBookId;
	}
	public void setEBookId(int EBookId) {
		this.EBookId = EBookId;
	}
	public String getEBookName() {
		return EBookName;
	}
	public void setEBookName(String EBookName) {
		this.EBookName = EBookName;
	}
	public int getEBookPrice() {
		return EBookPrice;
	}
	public void setEBookPrice(int EBookPrice) {
		this.EBookPrice = EBookPrice;
	}
	public String getEBookGrade() {
		return EBookGrade;
	}
	public void setEBookGrade(String EBookGrade) {
		this.EBookGrade = EBookGrade;
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
	public EBook(int EBookId, String EBookName, int EBookPrice, String EBookGrade, int tutorId, String tutorName) {
		super();
		this.EBookId = EBookId;
		this.EBookName = EBookName;
		this.EBookPrice = EBookPrice;
		this.EBookGrade = EBookGrade;
		this.tutorId = tutorId;
		this.tutorName = tutorName;
	}
	public EBook(String EBookName, int EBookPrice, String EBookGrade, int tutorId, String tutorName) {
		super();
		this.EBookName = EBookName;
		this.EBookPrice = EBookPrice;
		this.EBookGrade = EBookGrade;
		this.tutorId = tutorId;
		this.tutorName = tutorName;
	}
	@Override
	public String toString() {
		return "EBook [EBookId=" + EBookId + ", EBookName=" + EBookName + ", EBookPrice=" + EBookPrice + ", EBookGrade="
				+ EBookGrade + ", tutorId=" + tutorId + ", tutorName=" + tutorName + "]";
	}
    public EBook() {
		// TODO Auto-generated constructor stub
	}
	

}

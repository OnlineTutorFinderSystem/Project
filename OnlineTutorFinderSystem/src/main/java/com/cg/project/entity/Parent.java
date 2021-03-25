package com.cg.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parent {
	@Id
	@GeneratedValue
	private int parentId;
	private String parentName;
	private String parentEmail;
	private int parentPhone;

	public Parent() {
		// TODO Auto-generated constructor stub
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public int getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(int parentPhone) {
		this.parentPhone = parentPhone;
	}

	public Parent(int parentId, String parentName, String parentEmail, int parentPhone) {
		super();
		this.parentId = parentId;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentPhone = parentPhone;
	}

	@Override
	public String toString() {
		return parentId + " " + parentName + " " + parentEmail + " " + parentPhone;
	}

	public Parent(String parentName, String parentEmail, int parentPhone) {
		super();
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentPhone = parentPhone;
	}

}

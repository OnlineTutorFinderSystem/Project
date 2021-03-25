package com.cg.project.entity;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * @author VLH
 *
 */
@Component
@Table(name= "tutordetails")
public class TutorDetails {

	@Id
	int id;
	String name;
	long  salary;
	String subject;
	String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "TutorDetails [id=" + id + ", name=" + name + ", salary=" + salary + ", subject=" + subject
				+ ", address=" + address + "]";
	}
	public TutorDetails(int id, String name, long salary, String subject, String address) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.subject = subject;
		this.address = address;
	}
	public TutorDetails() {};
}

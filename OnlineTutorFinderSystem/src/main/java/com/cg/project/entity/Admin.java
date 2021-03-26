package com.cg.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rahul
 *
 */
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue
	private int adminId;
	private String adminName;
	private String adminEmailId;
	private String adminPhoneNo;

	public Admin (String adminName, String adminEmailId, String adminPhoneNo) {
		super();
		 
		this.adminName = adminName;
		this.adminEmailId = adminEmailId;
		this.adminPhoneNo = adminPhoneNo;
	}

	public Admin(int adminId, String adminName, String adminEmailId, String adminPhoneNo) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmailId = adminEmailId;
		this.adminPhoneNo = adminPhoneNo;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public String getAdminPhoneNo() {
		return adminPhoneNo;
	}

	public void setAdminPhoneNo(String adminPhoneNo) {
		this.adminPhoneNo = adminPhoneNo;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmailId=" + adminEmailId
				+ ", adminPhoneNo=" + adminPhoneNo + "]";
	}

	public Admin() {
		super();
		 
	}

}

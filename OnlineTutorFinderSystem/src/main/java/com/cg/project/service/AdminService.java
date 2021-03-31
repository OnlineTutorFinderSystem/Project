package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.Admin;

public interface AdminService {
	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(Admin admin);

	public String deleteAdmin(int adminId);

	public Optional<Admin> getAdminById(int adminId);

	public List<Admin> getAllAdmins();

	public List<Admin> getAllByAdminName(String adminName);

	public Admin getByAdminEmailId(String adminEmailId);

	public Admin getByAdminPhoneNo(String adminPhoneNo);

}
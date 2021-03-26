package com.cg.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.Admin;
import com.cg.project.entity.Books;
import com.cg.project.entity.Parent;
import com.cg.project.entity.Tutor;
import com.cg.project.repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;

	@Override
	public Admin addAdmin(Admin admin) {

		return dao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {

		return dao.save(admin);
	}

	@Override
	public String deleteAdmin(int adminId) {

		dao.deleteById(adminId);
		return "Deleted Successfully";
	}

	@Override
	public Optional<Admin> getAdminById(int adminId) {

		return dao.findById(adminId);
	}

	@Override
	public Tutor updateTutor(Tutor tutor) {

		return null;
	}

	@Override
	public Books updateBooks(Books book) {

		return null;
	}

	@Override
	public Parent viewParentsByName(Parent parent) {

		return null;
	}

	@Override
	public List<Parent> viewAllParents(Parent parent) {

		 
		return new ArrayList<>();
	}

	@Override
	public List<Admin> getAllByAdminName(String adminName) {
		return dao.findByAdminName(adminName);
	}

	@Override
	public Admin getByAdminEmailId(String adminEmailId) {
		return dao.findByAdminEmailId(adminEmailId);
	}

	@Override
	public Admin getByAdminPhoneNo(String adminPhoneNo) {
		return dao.findByAdminPhoneNo(adminPhoneNo);
	}

	@Override
	public List<Admin> getAllAdmins() {

		return dao.findAll();
	}
}

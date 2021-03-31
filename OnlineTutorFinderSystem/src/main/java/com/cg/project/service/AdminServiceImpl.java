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

/**
 * @author rahul
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;

	@Override
	public Admin addAdmin(Admin admin) // method to call save method from dao to add admin Info
	{

		return dao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) { // method to call save method from dao to update admin Info

		return dao.save(admin);
	}

	@Override
	public String deleteAdmin(int adminId) { // method to call delete by Id method from dao to delete particular admin
												// Info

		dao.deleteById(adminId);
		return "Deleted Successfully";
	}

	@Override
	public Optional<Admin> getAdminById(int adminId) {// method to call find by Id method from dao to fetch admin Info

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
	public List<Admin> getAllByAdminName(String adminName) {// method to call findbyAdminName method from dao to fetch
															// admin Info based on adminName

		return dao.findByAdminName(adminName);
	}

	@Override
	public Admin getByAdminEmailId(String adminEmailId) {// method to call findbyAdminEmailId method from dao to fetch
															// admin Info based on adminEmailId

		return dao.findByAdminEmailId(adminEmailId);
	}

	@Override
	public Admin getByAdminPhoneNo(String adminPhoneNo) {// method to call findbyAdminPhoneNo method from dao to fetch
															// admin Info based on adminPhoneNo

		return dao.findByAdminPhoneNo(adminPhoneNo);
	}

	@Override
	public List<Admin> getAllAdmins() {// method to call findAll method from dao to fetch all admins Info

		return dao.findAll();
	}
}

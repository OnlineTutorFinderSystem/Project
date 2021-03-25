 package com.cg.project.service;

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
		// TODO Auto-generated method stub
		return dao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return dao.save(admin);
	}

	@Override
	public String deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		dao.deleteById(adminId);
		return "Deleted Successfully";
	}

	@Override
	public Optional<Admin> getAdminById(int adminId) {
		// TODO Auto-generated method stub
		 return dao.findById(adminId);
	}

	@Override
	public Tutor updateTutor(Tutor tutor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Books updateBooks(Books book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent viewParentsByName(Parent parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parent> viewAllParents(Parent parent) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	}



package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.Admin;
import com.cg.project.entity.Books;
import com.cg.project.entity.Parent;
import com.cg.project.entity.Tutor;

public interface AdminService {
	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(Admin admin);

	public String deleteAdmin(int adminId);

	public Optional<Admin> getAdminById(int adminId);

	public Tutor updateTutor(Tutor tutor);

	public Books updateBooks(Books book);

	public Parent viewParentsByName(Parent parent);

	public List<Parent> viewAllParents(Parent parent);
}

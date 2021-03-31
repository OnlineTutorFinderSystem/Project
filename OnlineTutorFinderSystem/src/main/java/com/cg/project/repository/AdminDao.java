package com.cg.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.project.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	public List<Admin> findByAdminName(String adminName);

	public Admin findByAdminEmailId(String adminEmailId);

	public Admin findByAdminPhoneNo(String adminPhoneNo);
}
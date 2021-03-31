package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.DemoSession;
import com.cg.project.entity.Parent;
import com.cg.project.repository.ParentDao;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	DemoSessionService demoService;

	@Autowired
	ParentDao dao;

	@Override
	public Parent addParent(Parent parent) {
		return dao.save(parent);
	}

	@Override
	public Parent updateParent(Parent parent) {
		return dao.save(parent);
	}

	@Override
	public void deleteParent(int parentId) {
		dao.deleteById(parentId);
	}

	@Override
	public Optional<Parent> getParentById(int parentId) {
		return dao.findById(parentId);
	}

	@Override
	public List<Parent> getParentByEmail(String parentEmail) {
		return dao.findByparentEmail(parentEmail);
	}

	@Override
	public List<Parent> getParentByPhone(String parentPhone) {
		return dao.findByparentPhone(parentPhone);
	}

	@Override
	public List<Parent> getAllParents() {
		return dao.findAll();
	}

}

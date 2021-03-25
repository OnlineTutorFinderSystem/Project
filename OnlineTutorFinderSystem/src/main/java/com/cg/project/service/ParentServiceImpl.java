package com.cg.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.Parent;
import com.cg.project.repository.ParentDao;

@Service
public class ParentServiceImpl implements ParentService {

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

}

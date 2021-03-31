package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.DemoSession;
import com.cg.project.entity.Parent;

public interface ParentService {

	Parent addParent(Parent parent);

	Parent updateParent(Parent parent);

	void deleteParent(int parentId);

	Optional<Parent> getParentById(int parentId);

	List<Parent> getParentByEmail(String parentEmail);

	List<Parent> getParentByPhone(String parentPhone);

	List<Parent> getAllParents();
}

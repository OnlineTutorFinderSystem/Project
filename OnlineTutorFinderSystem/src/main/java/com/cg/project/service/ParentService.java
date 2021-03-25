package com.cg.project.service;

import java.util.Optional;

import com.cg.project.entity.Parent;

public interface ParentService {

	Parent addParent(Parent parent);

	Parent updateParent(Parent parent);

	void deleteParent(int parentId);

	Optional<Parent> getParentById(int parentId);
}

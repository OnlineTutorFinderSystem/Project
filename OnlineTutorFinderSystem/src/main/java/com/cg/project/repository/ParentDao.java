package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Parent;

@Repository
public interface ParentDao extends JpaRepository<Parent,Integer> {

}

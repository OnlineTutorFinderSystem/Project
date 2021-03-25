package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.project.entity.Admin;

 
@Repository
public interface AdminDao extends JpaRepository<Admin,Integer>{

}

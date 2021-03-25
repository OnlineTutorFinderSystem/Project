package com.cg.project.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Ebook;



@Repository
public interface EbookDao  extends JpaRepository<Ebook, Integer>{
	List<Ebook>findByEbookId(String EbookId);
	List<Ebook>findByEbookName(String EbookName);
}

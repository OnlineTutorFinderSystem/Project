package com.cg.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.project.entity.EBook;

@Repository
public interface EBookDao extends JpaRepository<EBook, Integer> {

	List<EBook> findByebookName(String ebookName);

	List<EBook> findByebookPrice(int ebookPrice);

}
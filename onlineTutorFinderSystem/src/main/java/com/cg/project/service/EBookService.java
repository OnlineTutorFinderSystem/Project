package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.EBook;

/**
 * @author NITIN
 *
 */
public interface EBookService {

	EBook addEBook(EBook ebook);

	EBook updateEBook(EBook ebook);

	void removeEBook(int ebookId);

	List<EBook> getEBookByName(String ebookName);

	List<EBook> getEBookByPrice(int ebookPrice);

	List<EBook> getAllEBook();

	Optional<EBook> getEBookById(int ebookId);

}

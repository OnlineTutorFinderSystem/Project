package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.EBook;
import com.cg.project.entity.EBook;


	public interface EBookService {

		EBook addEBook(EBook EBook);

		EBook updateEBook(EBook EBook);

		void removeEBook(int EBookId);

		List<EBook> getEBookByName(String EBookName);

		List<EBook> getEBookByPrice(int EBookPrice);
		
		List<EBook> getAllEBook();

		Optional<EBook> getEBookById(int EBookId);


		

		

		
}



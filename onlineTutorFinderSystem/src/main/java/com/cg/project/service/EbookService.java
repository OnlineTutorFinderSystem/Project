package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import com.cg.project.entity.Ebook;


	public interface EbookService {

		Ebook addEbook(Ebook Ebook);

		Ebook updateEbook(Ebook Ebook);

		void removeEbook(int EbookId);

		Optional<Ebook> getEbookByName(int EbookName);

		List<Ebook> getAllEbook();

		Optional<Ebook> getEbookById(int EbookId);

		

		
}



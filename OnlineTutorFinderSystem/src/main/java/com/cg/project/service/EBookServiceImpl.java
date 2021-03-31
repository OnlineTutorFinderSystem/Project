package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.EBook;
import com.cg.project.repository.EBookDao;

@Service("service")
@Transactional
public class EBookServiceImpl implements EBookService {

	@Autowired
	EBookDao dao;

	public EBook addEBook(EBook ebook) {

		return dao.save(ebook);
	}

	@Override
	public EBook updateEBook(EBook ebook) {

		return dao.save(ebook);
	}

	@Override
	public void removeEBook(int ebookId) {

		dao.deleteById(ebookId);
	}

	@Override

	public List<EBook> getEBookByName(String ebookName) {

		return dao.findByebookName(ebookName);
	}

	@Override
	public List<EBook> getAllEBook() {

		return dao.findAll();
	}

	@Override
	public Optional<EBook> getEBookById(int ebookId) {

		return dao.findById(ebookId);
	}

	@Override
	public List<EBook> getEBookByPrice(int ebookPrice) {

		return dao.findByebookPrice(ebookPrice);
	}

}
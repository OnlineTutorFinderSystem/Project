package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.Ebook;
import com.cg.project.repository.EbookDao;



@Service
public class EbookServiceImpl implements EbookService{
	@Autowired
	EbookDao dao;
	public Ebook addEbook(Ebook Ebook) {
		return dao.save(Ebook);
	}

	@Override
	public Ebook updateEbook(Ebook Ebook) {
		// TODO Auto-generated method stub
		return dao.save(Ebook);
	}

     @Override
	public List<Ebook> getAllEbook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ebook> getEbookByName(int EbookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ebook> getEbookById(int EbookId) {
		// TODO Auto-generated method stub
		return dao.findById(EbookId);
	}

	@Override
	public void removeEbook(int EbookId) {
		// TODO Auto-generated method stub
		dao.deleteById(EbookId);
	}
}


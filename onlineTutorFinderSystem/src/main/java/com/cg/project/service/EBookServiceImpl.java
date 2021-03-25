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
	public EBook addEBook(EBook EBook) {
		// TODO Auto-generated method stub
		return dao.save(EBook);
	}

	@Override
	public EBook updateEBook(EBook EBook) {
		// TODO Auto-generated method stub
		return dao.save(EBook);
	}

	@Override
	public void removeEBook(int EBookId) {
	
		dao.deleteById(EBookId);
	}

	@Override
	
	public List<EBook> getEBookByName(String EBookName){
		// TODO Auto-generated method stub
		 return dao.findByEBookName(EBookName);
	}

	@Override
	public List<EBook> getAllEBook() {
		// TODO Auto-generated method stub
		 return dao.findAll();
	}

	@Override
	public Optional<EBook> getEBookById(int EBookId) {
		// TODO Auto-generated method stub
		return dao.findById(EBookId);
	}

	@Override
	public List<EBook> getEBookByPrice(int EBookPrice) {
		// TODO Auto-generated method stub
		return dao.findByeBookPrice(EBookPrice);
	}
}



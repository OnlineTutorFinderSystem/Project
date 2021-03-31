package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.EBook;
import com.cg.project.repository.EBookDao;

/**
 * @author NITIN
 *
 */
/**
 * @author ASUS
 *
 */
@Service("service")
@Transactional
public class EBookServiceImpl implements EBookService {

	@Autowired
	EBookDao dao;

	public EBook addEBook(EBook ebook) {

		return dao.save(ebook);//this jpa method will add the corresponding ebook in the table
	}

	@Override
	public EBook updateEBook(EBook ebook) {

		return dao.save(ebook);//this jpa method will update the previously present ebook in the table
	}

	@Override
	public void removeEBook(int ebookId) {

		dao.deleteById(ebookId);//this jpa method will delete the existing ebook record from the table
	}

	@Override

	public List<EBook> getEBookByName(String ebookName) {

		return dao.findByebookName(ebookName);//this jpa method will display the ebook on basis of ebookname present in the table
	}

	@Override
	public List<EBook> getAllEBook() {

		return dao.findAll();//this jpa method simply display all the present  ebook record from the table

	}

	@Override
	public Optional<EBook> getEBookById(int ebookId) {

		return dao.findById(ebookId);//this jpa method will display the ebook on basis of ebookid present in the table
	}

	@Override
	public List<EBook> getEBookByPrice(int ebookPrice) {

		return dao.findByebookPrice(ebookPrice);//this  jpa method will display the ebook on basis of ebookprice present in the table
	}

}

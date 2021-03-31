package com.cg.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.project.entity.EBook;
import com.cg.project.exceptions.GlobalException;
import com.cg.project.service.EBookServiceImpl;

/**
 * @author NITIN
 *
 */
@RestController
@RequestMapping("/EBook") // optional
public class EBookController {

	@Autowired
	EBookServiceImpl service;

	@GetMapping("/getEBook/{EBookid}") // this method is basically used to get the ebooks based on corresponding
										// ebookid
	public Optional<EBook> getEBookById(@PathVariable("EBookid") int ebookId) {

		Optional<EBook> test = service.getEBookById(ebookId);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present");
		}

		return test;
	}

	@PostMapping("/addEBook") // this method will add the ebooks by giving default ebookid
	public EBook addEBook(@RequestBody EBook ebook)// get,post,put,delete
	{
		EBook test = service.addEBook(ebook);
		if (test.getEBookGrade() == null || test.getEBookName() == null || test.getEBookPrice() == 0
				|| test.getTutorId() == 0 || test.getTutorName() == null || test.getEBookPrice() >= 1000) {
			throw new GlobalException(
					"enter values correctly according to the data and ebook price should not exceed 1000");

		}
		return test;

	}

	@PutMapping("/updateEBook") // this method will update the data by selecting particular id
	public EBook updateEBook(@RequestBody EBook ebook)// get,post,put,delete
	{
		EBook test = service.updateEBook(ebook);
		if (test.getEBookId() == 0 || test.getEBookGrade() == null || test.getEBookName() == null
				|| test.getEBookPrice() == 0 || test.getTutorId() == 0 || test.getTutorName() == null) {
			throw new GlobalException("id is not present or entered incorrectly");
		}
		Optional<EBook> test1 = service.getEBookById(test.getEBookId());

		if (test1.isEmpty()) {
			throw new GlobalException("id is not present for updating");
		}
		return test;
	}

	@DeleteMapping("/deleteEBook/{EBookid}") // this method will delete the record
	public void deleteEBook(@PathVariable("EBookid") int ebookId)// get,post,put,delete
	{
		Optional<EBook> test = service.getEBookById(ebookId);
		if (test.isEmpty()) {
			throw new GlobalException("id is not present for deleting");
		}

		service.removeEBook(ebookId);

	}

	@GetMapping("/getAllEBook") // this method will display all the present records in the table
	public List<EBook> fetchAllEBook()// get,post,put,delete
	{
		List<EBook> test = service.getAllEBook();
		if (test.isEmpty())

		{
			throw new GlobalException("table is empty");
		}
		return test;
	}

	@GetMapping("/getAllEBookName/{EBookName}") // this methd will display all the ebooks based on ebookname
	public List<EBook> fetchAllEBookByName(@PathVariable("EBookName") String ebookName)// get,post,put,delete
	{
		List<EBook> test = service.getEBookByName(ebookName);
		if (test.isEmpty()) {
			throw new GlobalException("name is not present");
		}

		return test;

	}

	@GetMapping("/getAllEBookPrice/{EBookPrice}") // this method will display all the ebooks based on price
	public List<EBook> fetchAllEBookByPrice(@PathVariable("EBookPrice") int ebookPrice) {

		List<EBook> test = service.getEBookByPrice(ebookPrice);
		if (test.isEmpty()) {
			throw new GlobalException("price entered for ebook is not present");
		}

		return test;
	}
}

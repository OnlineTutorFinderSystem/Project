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

import com.cg.project.service.EBookServiceImpl;

@RestController
@RequestMapping("/EBook") // optional
public class EBookController {

	@Autowired
	EBookServiceImpl service;

	@GetMapping("/getEBook/{EBookid}")
	public Optional<EBook> getEBookById(@PathVariable("EBookid") int ebookId) {

		return service.getEBookById(ebookId);
	}

	@PostMapping("/addTrainee")
	public EBook addEBook(@RequestBody EBook ebook)// get,post,put,delete
	{
		return service.addEBook(ebook);

	}

	@PutMapping("/updateEBook")
	public EBook updateEBook(@RequestBody EBook ebook)// get,post,put,delete
	{
		return service.updateEBook(ebook);

	}

	@DeleteMapping("/deleteEBook/{EBookid}")
	public String deleteEBook(@PathVariable("EBookid") int ebookId)// get,post,put,delete
	{
		service.removeEBook(ebookId);
		return "deleted successfully";
	}

	@GetMapping("/getAllEBook")
	public List<EBook> fetchAllEBook()// get,post,put,delete
	{
		return service.getAllEBook();

	}

	@GetMapping("/getAllEBookid/{EBookid}")
	public Optional<EBook> fetchAllEBookByEBookid(@PathVariable("EBookid") int ebookid)// get,post,put,delete
	{
		return service.getEBookById(ebookid);

	}

	@GetMapping("/getAllEBookName/{EBookName}")
	public List<EBook> fetchAllEBookByName(@PathVariable("EBookName") String ebookName)// get,post,put,delete
	{
		return service.getEBookByName(ebookName);

	}

	@GetMapping("/getAllEBookPrice/{EBookPrice}")
	public List<EBook> fetchAllEBookByPrice(@PathVariable("EBookPrice") int ebookPrice) {
		return service.getEBookByPrice(ebookPrice);
	}
}

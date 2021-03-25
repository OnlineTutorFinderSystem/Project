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
	@RequestMapping("/EBook")//optional
	public class EBookController {


		@Autowired
		EBookServiceImpl service;
		@GetMapping("/getEBook/{EBookid}")//mand//json
		public Optional<EBook> getEBookById(@PathVariable("EBookid") int EBookId)
			{
			System.out.println(service.getEBookById(EBookId));
				return service.getEBookById(EBookId);
			}


		@PostMapping("/addTrainee")
        public EBook addEBook(@RequestBody EBook EBook)//get,post,put,delete
			{
			return service.addEBook(EBook);
				
			}
		@PutMapping("/updateEBook")
		public EBook updateEBook(@RequestBody EBook EBook)//get,post,put,delete
			{
			return service.updateEBook(EBook);
				
			}
		@DeleteMapping("/deleteEBook/{EBookid}")
		public String deleteEBook(@PathVariable("EBookid") int EBookId)//get,post,put,delete
			{
			 service.removeEBook(EBookId);
				return "deleted successfully";
			}
		@GetMapping("/getAllEBook")
		public List<EBook> fetchAllEBook()//get,post,put,delete
			{
			return service.getAllEBook();
				
			}
		@GetMapping("/getAllEBookid/{EBookid}")
		public Optional<EBook> fetchAllEBookByEBookid(@PathVariable("EBookid") int EBookid )//get,post,put,delete
			{
			return service.getEBookById(EBookid);
				
			}
		@GetMapping("/getAllEBookName/{EBookName}")
		public List<EBook> fetchAllEBookByName(@PathVariable("EBookName") String EBookName )//get,post,put,delete
			{
			return service.getEBookByName(EBookName);
				
			}
	}



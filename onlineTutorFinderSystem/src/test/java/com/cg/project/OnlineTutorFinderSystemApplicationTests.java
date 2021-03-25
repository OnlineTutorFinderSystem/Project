package com.cg.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.project.entity.EBook;
import com.cg.project.repository.EBookDao;
import com.cg.project.service.EBookService;






@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {
    @MockBean
    EBookDao dao;
    @Autowired
    EBookService service;
	@Test
	public void testAddEBook()
	  {
	   EBook EBook = new EBook("science",220,"X",2000,"AKASH");
	   when(dao.save(EBook)).thenReturn(EBook);
	  
	   EBook result=service.addEBook(EBook);
	    assertEquals("science",result.getEBookName());
	  }
   
	 @Test
    void testUpdateEBook() {
		 EBook EBook= new EBook(1,"science",330,"X1",2001,"raman");
		 when(dao.save(EBook)).thenReturn(EBook);
		 EBook result=service.updateEBook(EBook);
		 assertEquals(1,result.getEBookId());
		 assertEquals("science",result.getEBookName());
	 }
	 @Test
	 void testDeleteEBook() {
			 EBook EBook= new EBook(1,"maths",400,"XII",2002,"SURESH");
			 service.addEBook(EBook);
			 service.removeEBook(1);
			 Optional<EBook> deletedEBook = service.getEBookById(1);
			 assertEquals(Optional.empty(),deletedEBook);
			 
	 }
	@Test
	void testFindEBook() {
		EBook EBook = new EBook(2,"biology",500,"XII",2003,"ARUN");
		when(dao.findById(2)).thenReturn(Optional.of(EBook));
		Optional<EBook> result = service.getEBookById(2);
		assertTrue(result.isPresent());
		
		
	}
		 
		 
		 
		 
	 }



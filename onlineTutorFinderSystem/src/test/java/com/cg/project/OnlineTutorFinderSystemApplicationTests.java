package com.cg.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.project.entity.Ebook;
import com.cg.project.repository.EbookDao;
import com.cg.project.service.EbookService;



@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {
    @MockBean
    EbookDao dao;
    @Autowired
    EbookService service;
	@Test
	public void testAddEbook()
	  {
	   Ebook Ebook = new Ebook("science","X",2000,"akash");
	   when(dao.save(Ebook)).thenReturn(Ebook);
	  
	   Ebook result=service.addEbook(Ebook);
	    assertEquals("science",result.getEbookName());
	  }
   
	 @Test
    void testUpdateEbook() {
		 Ebook Ebook= new Ebook(1,"science","X1",2001,"raman");
		 when(dao.save(Ebook)).thenReturn(Ebook);
		 Ebook result=service.updateEbook(Ebook);
		 assertEquals(1,result.getEbookId());
		 assertEquals("science",result.getEbookName());
	 }
	 @Test
	 void testDeleteEbook() {
			 Ebook Ebook= new Ebook(1,"maths","X",2002,"shyam");
			 service.removeEbook(1);
			 Optional<Ebook> deletedEbook = service.getEbookById(1);
			 assertEquals(Optional.empty(), deletedEbook);
			 
	 }
	@Test
	void testFindEbook() {
		Ebook Ebook = new Ebook(2,"biology","XII",2003,"Pawan");
		when(dao.findById(2)).thenReturn(Optional.of(Ebook));
		Optional<Ebook> result = service.getEbookById(2);
		assertTrue(result.isPresent());
		
		
	}
		 
		 
		 
		 
	 }



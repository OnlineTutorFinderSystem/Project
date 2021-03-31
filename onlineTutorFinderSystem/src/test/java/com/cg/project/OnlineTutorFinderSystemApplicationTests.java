package com.cg.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.project.entity.EBook;
import com.cg.project.repository.EBookDao;
import com.cg.project.service.EBookService;

/**
 * @author NITIN
 *
 */
@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {
	@MockBean
	EBookDao dao;
	@Autowired
	EBookService service;

	@Test
	void testAddEBook() {
		EBook EBook = new EBook("science", 220, "X", 2000, "AKASH");
		when(dao.save(EBook)).thenReturn(EBook);

		EBook result = service.addEBook(EBook);
		assertEquals("science", result.getEBookName());
	}

	@Test
	void testUpdateEBook() {
		EBook EBook = new EBook(1, "science", 330, "X1", 2001, "raman");
		when(dao.save(EBook)).thenReturn(EBook);
		EBook result = service.updateEBook(EBook);
		assertEquals(1, result.getEBookId());
		assertEquals("science", result.getEBookName());
	}

	@Test
	void testDeleteEBook() {
		EBook EBook = new EBook(1, "maths", 400, "XII", 2002, "SURESH");
		service.removeEBook(1);
		Optional<EBook> deletedEBook = service.getEBookById(1);
		assertEquals(Optional.empty(), deletedEBook);

	}

	@Test
	void testFindEBook() {
		EBook EBook = new EBook(2, "biology", 500, "XII", 2003, "ARUN");
		when(dao.findById(2)).thenReturn(Optional.of(EBook));
		Optional<EBook> result = service.getEBookById(2);
		assertTrue(result.isPresent());

	}

	@Test
	void testFindEBookByName() {
		EBook EBook = new EBook(3, "hindi", 600, "X", 2004, "PAWAN");
		List<EBook> list = new ArrayList<EBook>();
		list.add(EBook);
		when(dao.findByebookName("hindi")).thenReturn(list);
		List<EBook> result = service.getEBookByName(EBook.getEBookName());
		assertEquals(result, list);
	}

	@Test
	void testFindEBookByPrice() {
		EBook EBook = new EBook(4, "english", 700, "X1", 2005, "ANURAG");
		List<EBook> list1 = new ArrayList<EBook>();
		list1.add(EBook);
		when(dao.findByebookPrice(700)).thenReturn(list1);
		List<EBook> result = service.getEBookByPrice(EBook.getEBookPrice());
		assertEquals(result, list1);
	}

	@Test
	void testFindAllEBook() {
		EBook EBook = new EBook(5, "history", 450, "X", 2006, "RAJAT");
		List<EBook> list3 = new ArrayList<EBook>();
		list3.add(EBook);
		when(dao.findAll()).thenReturn(list3);
		List<EBook> result = service.getAllEBook();
		assertEquals(result, list3);
	}
}

package com.cg.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.project.entity.Admin;
import com.cg.project.repository.AdminDao;
import com.cg.project.service.AdminService;

@SpringBootTest
class OnlineTutorFinderSystemApplicationTests {
	@MockBean
	AdminDao dao;

	@Autowired
	AdminService service;

	@Test
	public void testAddAdmin() {

		Admin admin = new Admin("rahul", "admin@gmail.com", "9876543210");
		when(dao.save(admin)).thenReturn(admin);
		Admin result = service.addAdmin(admin);
		assertEquals("rahul", result.getAdminName());

	}

	@Test
	public void testUpdateAdmin() {
		Admin admin = new Admin(1, "dummyname", "dummy@gmail.com", "9123456789");
		when(dao.save(admin)).thenReturn(admin);
		Admin result = service.updateAdmin(admin);
		assertEquals("dummyname", result.getAdminName());
	}

	
	  @Test 
	  public void testGetAdminById() { 
		  Admin admin = (new Admin(32,"dummyName11","muddy@gmail.com","9870987123"));
	  when(dao.findById(32)).thenReturn(Optional.of(admin)); 
	  Optional<Admin> result= service.getAdminById(32);
			  assertTrue(result.isPresent()); 
			  }
	 @Test 
	 public void testDeleteAdmin()
	 {
		 Admin admin = new Admin(44,"dummyName11","muddy@gmail.com","9870987123");
		 service.deleteAdmin(44);
		 Optional<Admin> admin1 =service.getAdminById(44);
		 assertEquals(Optional.empty(),admin1);
	 }
}

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

import com.cg.project.entity.Admin;
import com.cg.project.repository.AdminDao;
import com.cg.project.service.AdminService;

@SpringBootTest
class AdminModuleTests {
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
		Admin admin = (new Admin(32, "dummyName11", "muddy@gmail.com", "9870987123"));
		when(dao.findById(32)).thenReturn(Optional.of(admin));
		Optional<Admin> result = service.getAdminById(32);
		assertTrue(result.isPresent());
	}

	@Test
	public void testDeleteAdmin() {
		Admin admin = new Admin(44, "dummyName11", "muddy@gmail.com", "9870987123");
		service.deleteAdmin(44);
		Optional<Admin> admin1 = service.getAdminById(44);
		assertEquals(Optional.empty(), admin1);
	}

	@Test
	public void testGetAllByAdminName() {
		Admin admin = new Admin(42, "namedummy", "maildummy@gmail.com", "98888888");
		List<Admin> list = new ArrayList<Admin>();
		list.add(admin);
		when(dao.findByAdminName("namedummy")).thenReturn(list);
		List<Admin> result = service.getAllByAdminName("namedummy");
		assertEquals(list, result);
	}

	@Test
	public void testGetByAdminEmailId() {
		Admin admin = new Admin(1, "dummyname", "dummyem@gmail.com", "980678765");
		when(dao.findByAdminEmailId("dummyem@gmail.com")).thenReturn(admin);
		Admin result = service.getByAdminEmailId("dummyem@gmail.com");
		assertEquals("dummyname", result.getAdminName());
	}

	@Test
	public void testGetByAdminPhoneNo() {
		Admin admin = new Admin(1, "dummyname", "dummyem@gmail.com", "980678765");
		when(dao.findByAdminPhoneNo("980678765")).thenReturn(admin);
		Admin result = service.getByAdminPhoneNo("980678765");
		assertEquals("dummyname", result.getAdminName());
	}

}
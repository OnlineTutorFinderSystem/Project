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
import com.cg.project.entity.Admin;
import com.cg.project.service.AdminServiceImpl;
 
 

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	AdminServiceImpl service;
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return(service.addAdmin(admin));
	}
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin)
	{
		return(service.updateAdmin(admin));
	}
	@DeleteMapping("/deleteAdmin/{adminId}")
	public String deleteAdmin(@PathVariable("adminId") int adminId)
	{
		return(service.deleteAdmin(adminId));
	}
	@GetMapping("/getAdminById/{adminId}")
	public Optional<Admin> getAdminById(@PathVariable("adminId") int adminId)
	{
		return (service.getAdminById(adminId));
	}
	@GetMapping("/getAllByAdminName/{adminName}")
	public List<Admin> fetchAllByAdminName(@PathVariable("adminName") String adminName) {
		return service.getAllByAdminName(adminName);
	}
@GetMapping("/getByAdminEmailId/{adminEmailId}")
	public Admin fetchByAdminEmailId(@PathVariable("adminEmailId") String adminEmailId) {
		return service.getByAdminEmailId(adminEmailId);
	}
@GetMapping("/getByAdminPhoneNo/{adminPhoneNo}")
	public Admin fetchByAdminPhoneNo(@PathVariable("adminPhoneNo") String adminPhoneNo) {
		return service.getByAdminPhoneNo(adminPhoneNo);
	}
@GetMapping("/getAllAdmins")
public List<Admin> fetchAllAdmins()
{
	return(service.getAllAdmins());
}
}

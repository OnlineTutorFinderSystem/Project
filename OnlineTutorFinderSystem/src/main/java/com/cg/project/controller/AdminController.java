package com.cg.project.controller;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
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
import com.cg.project.exceptions.GlobalException;
import com.cg.project.service.AdminServiceImpl;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	AdminServiceImpl service;

	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		Admin test = service.addAdmin(admin);
		if (test.getAdminEmailId() == null || test.getAdminName() == null || test.getAdminPhoneNo() == null
				|| test.getAdminPhoneNo().length() != 10)
			throw new GlobalException("InCorrect Details.Enter proper details for AdminName,AdminEmailId and AdminPhoneNo ");
		return test;
	}

	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		Admin test = service.updateAdmin(admin);
		if(test.getAdminId()==0 || test.getAdminEmailId()==null || test.getAdminPhoneNo()== null || test.getAdminPhoneNo().length()!=10)
			throw new GlobalException("InCorrect Details.Enter proper details for AdminName,AdminEmailId and AdminPhoneNo ");
		return test;
	}

	@DeleteMapping("/deleteAdmin/{adminId}")
	public String deleteAdmin(@PathVariable("adminId") int adminId) {
		 String test = service.deleteAdmin(adminId);
		  if(test!= "Deleted Successfully")
		  {
			  throw new GlobalException("Enter Valid AdminId");
		  }
		  return test;
	}

	@GetMapping("/getAdminById/{adminId}")
	public Optional<Admin> getAdminById(@PathVariable("adminId") int adminId) {
	 Optional<Admin> test =(service.getAdminById(adminId));
	 if(test.isEmpty())
	 {
		 throw new GlobalException("AdminId is Incorrect.Enter a vaild AdminId");
	 }
 return test;
	}

	@GetMapping("/getAllByAdminName/{adminName}")
	public List<Admin> fetchAllByAdminName(@PathVariable("adminName") String adminName) {
		List<Admin> list= service.getAllByAdminName(adminName);
		if(list.isEmpty() || adminName==null)
		{
			throw new GlobalException("AdminName Doesnot Exsist.Enter valid Admin Name");
		}
		return list;
	}

	@GetMapping("/getByAdminEmailId/{adminEmailId}")
	public Admin fetchByAdminEmailId(@PathVariable("adminEmailId") String adminEmailId) {
		 Admin test = service.getByAdminEmailId(adminEmailId);
		if(test == null )
		{
			throw new GlobalException("Enter Valid Details.Admin Email Is Not Present");
		}
		return test;
	}

	@GetMapping("/getByAdminPhoneNo/{adminPhoneNo}")
	public Admin fetchByAdminPhoneNo(@PathVariable("adminPhoneNo") String adminPhoneNo) {
		Admin test =service.getByAdminPhoneNo(adminPhoneNo);
		if(test.getAdminPhoneNo()==null)
		{
			throw new GlobalException("Enter Valid Details.Admin Phone Number Is Not Present");
		}
		return test;
	}

	@GetMapping("/getAllAdmins")
	public List<Admin> fetchAllAdmins() {
		List<Admin> test= (service.getAllAdmins());
		if(test.isEmpty())
		{
			throw new GlobalException("No Admins present.Add Admins to fetch details");
		}
		return test;
	}
}

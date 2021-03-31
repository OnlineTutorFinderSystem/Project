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
import com.cg.project.entity.EBook;
import com.cg.project.entity.Parent;
import com.cg.project.entity.TutorDetails;
import com.cg.project.exceptions.GlobalException;
import com.cg.project.service.AdminServiceImpl;
import com.cg.project.service.EBookServiceImpl;
import com.cg.project.service.ParentServiceImpl;
import com.cg.project.service.TutorServiceImpl;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	TutorServiceImpl tutorService;
	@Autowired
	EBookServiceImpl ebookService;
	@Autowired
	ParentServiceImpl parentService;
	@Autowired
	AdminServiceImpl service;

	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		Admin test = service.addAdmin(admin);
		if (test.getAdminEmailId() == null || test.getAdminName() == null || test.getAdminPhoneNo() == null
				|| test.getAdminPhoneNo().length() != 10)
			throw new GlobalException(
					"InCorrect Details.Enter proper details for AdminName,AdminEmailId and AdminPhoneNo ");
		return test;
	}

	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		Admin test = service.updateAdmin(admin);
		if (test.getAdminId() == 0 || test.getAdminEmailId() == null || test.getAdminPhoneNo() == null
				|| test.getAdminPhoneNo().length() != 10)
			throw new GlobalException(
					"InCorrect Details.Enter proper details for AdminName,AdminEmailId and AdminPhoneNo ");
		return test;
	}

	@DeleteMapping("/deleteAdmin/{adminId}")
	public String deleteAdmin(@PathVariable("adminId") int adminId) {
		String test = service.deleteAdmin(adminId);
		if (test != "Deleted Successfully") {
			throw new GlobalException("Enter Valid AdminId");
		}
		return test;
	}

	@GetMapping("/getAdminById/{adminId}")
	public Optional<Admin> getAdminById(@PathVariable("adminId") int adminId) {
		Optional<Admin> test = (service.getAdminById(adminId));
		if (test.isEmpty()) {
			throw new GlobalException("AdminId is Incorrect.Enter a vaild AdminId");
		}
		return test;
	}

	@GetMapping("/getAllByAdminName/{adminName}")
	public List<Admin> fetchAllByAdminName(@PathVariable("adminName") String adminName) {
		List<Admin> list = service.getAllByAdminName(adminName);
		if (list.isEmpty() || adminName == null) {
			throw new GlobalException("AdminName Doesnot Exsist.Enter valid Admin Name");
		}
		return list;
	}

	@GetMapping("/getByAdminEmailId/{adminEmailId}")
	public Admin fetchByAdminEmailId(@PathVariable("adminEmailId") String adminEmailId) {
		Admin test = service.getByAdminEmailId(adminEmailId);
		if (test == null) {
			throw new GlobalException("Enter Valid Details.Admin Email Is Not Present");
		}
		return test;
	}

	@GetMapping("/getByAdminPhoneNo/{adminPhoneNo}")
	public Admin fetchByAdminPhoneNo(@PathVariable("adminPhoneNo") String adminPhoneNo) {
		Admin test = service.getByAdminPhoneNo(adminPhoneNo);
		if (test.getAdminPhoneNo() == null) {
			throw new GlobalException("Enter Valid Details.Admin Phone Number Is Not Present");
		}
		return test;
	}

	@GetMapping("/getAllAdmins")
	public List<Admin> fetchAllAdmins() {
		List<Admin> test = (service.getAllAdmins());
		if (test.isEmpty()) {
			throw new GlobalException("No Admins present.Add Admins to fetch details");
		}
		return test;
	}

	@GetMapping("/getAllParents")
	public List<Parent> getAllParents() {
		List<Parent> test = parentService.getAllParents();
		if (test.isEmpty()) {
			throw new GlobalException("Table is empty.");
		}
		return test;
	}

	@PostMapping("/addParent")
	public Parent addParent(@RequestBody Parent parent) {
		Parent test = parentService.addParent(parent);
		if (test.getParentName() == null || test.getParentPhone() == null || test.getParentEmail() == null
				|| test.getParentPhone().length() != 10) {
			throw new GlobalException("Enter values for body correctly or check the phone no");
		}
		return test;
	}

	@GetMapping("/getAllEBook")
	public List<EBook> fetchAllEBook() {
		List<EBook> test = ebookService.getAllEBook();
		if (test.isEmpty())

		{
			throw new GlobalException("table is empty");
		}
		return test;
	}

	@PostMapping("/addEbook")
	public EBook addEBook(@RequestBody EBook ebook)// get,post,put,delete
	{
		EBook test = ebookService.addEBook(ebook);
		if (test.getEBookGrade() == null || test.getEBookName() == null || test.getEBookPrice() == 0
				|| test.getTutorId() == 0 || test.getTutorName() == null || test.getEBookPrice() >= 1000) {
			throw new GlobalException(
					"enter values correctly according to the data and ebook price should not exceed 1000");

		}
		return test;

	}

	@GetMapping("/getAllTutors")
	public List<TutorDetails> getAllTutors() {
		List<TutorDetails> test = tutorService.getAllTutors();
		if (test.isEmpty()) {
			throw new GlobalException("Table is empty.");
		}
		return test;
	}

	@PostMapping("/addTutor")
	public TutorDetails createTutor(@RequestBody TutorDetails tutor) {
		TutorDetails test = tutorService.addTutor(tutor);
		if (test.getTutorName() == null || test.getTutorSalary() == 0 || test.getTutorSubject() == null
				|| test.getTutorLocality() == null) {
			throw new GlobalException("Enter values for body correctly ");
		}
		return test;

	}
}
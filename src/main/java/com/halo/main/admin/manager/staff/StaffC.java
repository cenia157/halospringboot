package com.halo.main.admin.manager.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/admin/manager")
@Controller
public class StaffC {
	
	@Autowired
	private StaffService service;
	

	@GetMapping("/staff")
	public String goStaff(Model model) {
		service.goStaff(model);
		return "/admin/index";
	}
	
	@ResponseBody
	@GetMapping("/staff/list")
	public List<Staff> getAllStaffList(Staff staff) {
		return service.getAllStaffList(staff);
	}
	
	@ResponseBody
	@PostMapping("/staff")
	public int regStaff(@RequestBody Staff staff) {
		return service.regStaff(staff);
	}
	
	@ResponseBody
	@PutMapping("/staff")
	public int updateStaff(@RequestBody Staff staff) {
		return service.updateStaff(staff);
		
	}
	@ResponseBody
	@DeleteMapping("/staff")
	public int deleteStaff(@RequestBody Staff staff) {
		return service.deleteStaff(staff);
		
	}
	
}

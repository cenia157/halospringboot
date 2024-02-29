package com.halo.main.admin.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin/schedule")
public class EmployeeC {
	
	@Autowired
	private EmployeeService eService;
	
	@GetMapping("/employee")
	public String employee(Model model) {
		
		model.addAttribute("menuname", "スタッフのスケジュール");
		model.addAttribute("menu", "/views/admin/calender/employee/employeeContent.jsp");
		
		return "/admin/index";
	}
	
	@ResponseBody
	@GetMapping("/employee/list")
	public List<EmployeeDTO> getEmployeerList() {
		return eService.getEmployeerList();
	}
	
	@ResponseBody
	@GetMapping("/employee/sift")
	public List<SiftDTO> getEmployeerSift() {
		return eService.getEmployeerSift();
	}
	
	@ResponseBody
	@PostMapping("/employee/insert")
	public int insertSift(@RequestBody SiftDTO sDTO) {
		return eService.insertSift(sDTO);
	}
	
	@ResponseBody
	@PutMapping("/employee/update")
	public int updateSift(@RequestBody SiftDTO sDTO) {
		return eService.updateSift(sDTO);
	}
	
	@ResponseBody
	@DeleteMapping("/employee/delete")
	public int deleteSift(@RequestBody SiftDTO sDTO) {
		return eService.deleteSift(sDTO);
	}
}

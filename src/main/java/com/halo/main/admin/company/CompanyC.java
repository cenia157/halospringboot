package com.halo.main.admin.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CompanyC {
	
	@Autowired
	private CompanyService cService;
	
	@GetMapping("/company")
	public String company(Model model) {
		
		model.addAttribute("menuname", "会社のスケジュール");
		model.addAttribute("menu", "/WEB-INF/views/admin/calender/company/companyContent.jsp");
		
		return "/admin/index";
	}
	
	@ResponseBody
	@GetMapping("/company/scheduleList")
	public List<CompanyScheduleDTO> getCompanyScheduleList() {
		return cService.getCompanyScheduleList();
	}
	
	@ResponseBody
	@PostMapping("/company/insert")
	public int insertCompanySchedule(@RequestBody CompanyScheduleDTO csDTO) {
		return cService.insertCompanySchedule(csDTO);
	}
	
	@ResponseBody
	@PutMapping("/company/update")
	public int updateTxtCompanySchedule(@RequestBody CompanyScheduleDTO csDTO) {
		return cService.updateTxtCompanySchedule(csDTO);
	}
	
	@ResponseBody
	@PutMapping("/company/delete")
	public int deleteCompanySchedule(@RequestBody CompanyScheduleDTO csDTO) {
		System.out.println(csDTO);
		return cService.deleteCompanySchedule(csDTO);
	}
	
	@ResponseBody
	@DeleteMapping("/company/deleterow")
	public int deleteRowCompanySchedule(@RequestBody CompanyScheduleDTO csDTO) {
		System.out.println(csDTO);
		return cService.deleteRowCompanySchedule(csDTO);
	}
}

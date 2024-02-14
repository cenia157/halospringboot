package com.halo.main.admin.customerCare.customerInfoMgmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.halo.main.admin.reservation.ReservationScheduleAcceptDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/admin/customerCare/customerInfoMgmt")
@Controller
public class CustomerInfoMgmtC {

	@Autowired
	private CustomerInfoMgmtService service;
	
	@GetMapping("")
	public String goCustomerInfo(Model model) {
		
		service.goCustomerInfo(model);
		return "/admin/index";
	}
	
	@ResponseBody
	@PostMapping("")
	public List<ReservationScheduleAcceptDTO> getCustomerInfo() {
		return service.getCustomerInfo();
		
	}
	
	
	
}

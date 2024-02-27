package com.halo.main.admin.customerCare.customerInfoMgmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.halo.main.admin.reservation.ReservationScheduleAcceptDTO;

 
@Service
public class CustomerInfoMgmtService {
	
	@Autowired
	private customerInfoMgmtMapper customerInfoMgmtMapper;

	public void goCustomerInfo(Model model) {
		model.addAttribute("menuname", "確定予約リスト");
		model.addAttribute("menu", "/WEB-INF/views/admin/customerCare/customerInfoMgmt/customerInfoMgmt.jsp");
		
	}
	public List<ReservationScheduleAcceptDTO> getCustomerInfo() {
		
		return customerInfoMgmtMapper.getCustomerInfo();
		
	}

	
}

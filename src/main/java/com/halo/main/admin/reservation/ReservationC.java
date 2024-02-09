package com.halo.main.admin.reservation;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReservationC {

	@Autowired
	private ReservationService rService;

	@GetMapping("/reservation")
	public String reservation(Model model) {
		model.addAttribute("menuname", "顧客の予約");
		model.addAttribute("menu", "/WEB-INF/views/admin/calender/reservation/reservationContent.jsp");

		return "/admin/index";
	}

	@ResponseBody
	@GetMapping("/reservation/informlist")
	public List<ReservationScheduleDTO> getInformList() {
		return rService.getInformList();
	}

	@ResponseBody
	@GetMapping("/reservation/acceptlist")
	public List<ReservationScheduleAcceptDTO> getAcceptList() {
		return rService.getAcceptList();
	}

	@ResponseBody
	@GetMapping("/reservation/stafflist")
	public List<StaffDTO> getStaffList() {
		return rService.getStaffList();
	}

	@ResponseBody
	@PostMapping("/reservation/accept")
	public int reservationAccept(@RequestBody ReservationScheduleDTO rsDTO) {
		System.out.println(rsDTO);
		if (rService.reservationAccept(rsDTO) == 1) {
			return rService.deleteInform(rsDTO);
		} else
			return 0;
	}

	@ResponseBody
	@PostMapping("/reservation/decline")
	public int reservationDecline(@RequestBody ReservationScheduleDTO rsDTO) {
		System.out.println(rsDTO);
		if (rService.reservationDecline(rsDTO) == 1) {
			return rService.deleteInform(rsDTO);
		} else
			return 0;
	}

	@ResponseBody
	@PutMapping("/reservation/update")
	public int reservationUpdate(@RequestBody ReservationScheduleAcceptDTO rsaDTO) {
		System.out.println(rsaDTO);
		return rService.reservationUpdate(rsaDTO);
	}
	
	@ResponseBody
	@DeleteMapping("/reservation/delete")
	public int reservationDelete(@RequestBody ReservationScheduleAcceptDTO rsaDTO) {
		System.out.println(rsaDTO);
		if (rService.reservationDelete(rsaDTO) == 1) {
			return rService.acceptToDecline(rsaDTO);
		} else return 0;
	}
	
	@ResponseBody
	@PostMapping("/reservation/insert")
	public int reservationInsert(@RequestBody ReservationScheduleAcceptDTO rsaDTO) {
		System.out.println(rsaDTO);
		return rService.reservationInsert(rsaDTO);
	}

}

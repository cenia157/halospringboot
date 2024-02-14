package com.halo.main.user.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halo.main.admin.reservation.ReservationScheduleDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/service")
@Controller
public class ServiceC {
	
	@Autowired
	private ServiceDAO serviceDAO; 
	
	@GetMapping("/info")
	public String serviceInfo (Model model) {
		serviceDAO.goServiceInfo(model);
		return "index";
	}
	
	@GetMapping("/apply")
	public String svcApply(Model model) {
		return "redirect:apply/step1/svc";
	}
	@GetMapping("/apply/step1/svc")
	public String svcSelect(Model model) {
		serviceDAO.goSvcSelect(model);
		return "index";
	}
	
	@PostMapping("/apply/step2/calendar")
	public String calSelect(Model model, HttpServletRequest request) {
		serviceDAO.goCalSelect(model);
		serviceDAO.svcSelect(request);
		return "index";
	}
	@PostMapping("/apply/step3/time")
	public String timeSelect(Model model, HttpServletRequest request) {
		serviceDAO.goTimeSelect(model, request);
		serviceDAO.calSelect(model, request);

		return "index";
	}
	
	@PostMapping("/apply/step4/nursingform")
	public String nursingApplyForm(Model model, HttpServletRequest request)  {
		serviceDAO.goNrsingApplyForm(model, request);
		serviceDAO.calSelect(model, request);
		serviceDAO.tiemSelect(model, request);
		return "index";
	}
	@PostMapping("/apply/step4/taxiform")
	public String taxiApplyForm(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		serviceDAO.goTaxiApplyForm(model);
		serviceDAO.calSelect(model, request);
		serviceDAO.tiemSelect(model, request);
		serviceDAO.nusingApply(model, request);
		return "index";
	}
	@PostMapping("/apply/step5/agree")
	public String agree(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		serviceDAO.goAgree(model);
		serviceDAO.calSelect(model, request);
		serviceDAO.tiemSelect(model, request);
		serviceDAO.nusingApply(model, request);
		serviceDAO.taxiApply(model, request);
		return "index";
	}
	@PostMapping("/apply/step6/complet")
	public String complet(Model model, HttpServletRequest request, ReservationScheduleDTO rsDTO) throws UnsupportedEncodingException {
		serviceDAO.goComplet(model);
		serviceDAO.serviceApply(rsDTO, request);
		return "index";
	}
	
	
	
}
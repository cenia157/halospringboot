package com.halo.main.user.service;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.halo.main.admin.reservation.ReservationScheduleDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ServiceDAO {

	public void goServiceInfo(Model model) {
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceInformation/serviceInformation.jsp");
		
	}
	
	public void goSvcSelect(Model model) {
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");
		model.addAttribute("step1Pos", "#ffdf6c");
		model.addAttribute("serviceStep", "svcselect.jsp");
		
	}
	
	public void goCalSelect(Model model) {
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");
		model.addAttribute("step2Pos", "#ffdf6c");
		model.addAttribute("serviceStep", "calselect.jsp");
		
	}
	
	public void goTimeSelect(Model model, HttpServletRequest request) {
		
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");
		model.addAttribute("step3Pos", "#ffdf6c");
		model.addAttribute("serviceStep", "timeselect.jsp");
		// 세션 객체 가져오기
		HttpSession session = request.getSession();

		// 세션에서 데이터 불러오기
		String selectedService = (String) session.getAttribute("selectedService");
		String nextStep = null;
		// 불러온 데이터 사용 예시
		if (selectedService != null) {
			if (selectedService.equals("taxi")) {
				nextStep = "/service/apply/step4/taxiform";
			} else {
				nextStep = "/service/apply/step4/nursingform";
			}
			model.addAttribute("nextStep", nextStep);

			System.out.println("Selected Service: " + selectedService);
		} else {
			System.out.println("No selected service found in session.");
		}

		
	}
	
	public void goNrsingApplyForm(Model model, HttpServletRequest request) {
		model.addAttribute("step4Pos", "#ffdf6c");
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");
		model.addAttribute("serviceStep", "nursingapply.jsp");
		// 세션 객체 가져오기
		HttpSession session = request.getSession();

		// 세션에서 데이터 불러오기
		String selectedService = (String) session.getAttribute("selectedService");
		String nextStep = null;
		// 불러온 데이터 사용 예시
		if (selectedService != null) {

			if (selectedService.equals("nursingTaxi")) {
				nextStep = "/service/apply/step4/taxiform";
			} else {
				nextStep = "/service/apply/step5/agree";
			}


		}
		model.addAttribute("nextStep", nextStep);
	}
	
	public void goTaxiApplyForm(Model model) {
		model.addAttribute("serviceStep", "taxiapply.jsp");
		model.addAttribute("step4Pos", "#ffdf6c");
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");
		
	}
	
	public void goAgrer(Model model) {
		model.addAttribute("serviceStep", "agree.jsp");
		model.addAttribute("step5Pos", "#ffdf6c");
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");
		
	}
	
	
	
	
	
	
	
	
	

	public void svcSelect(HttpServletRequest request) {
		String selectedService = request.getParameter("sa_service");
		HttpSession session = request.getSession();
		session.setAttribute("selectedService", selectedService);
	}

	public void calSelect(Model model, HttpServletRequest request) {
		String selectedStart = request.getParameter("selectedStart");
		String selectedEnd = request.getParameter("selectedEnd");

		model.addAttribute("selectedStart", selectedStart);
		model.addAttribute("selectedEnd", selectedEnd);

	}

	public void tiemSelect(Model model, HttpServletRequest request) {
		String selectedTime = request.getParameter("selectedTime");

		model.addAttribute("selectedTime", selectedTime);


	}

	public void nusingApply(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		// 문자인코딩형식
		request.setCharacterEncoding("UTF-8");
		String applicant = request.getParameter("applicant");
		String phoneNum = request.getParameter("phoneNum");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String addr = request.getParameter("addr");
		String niText = request.getParameter("niText");

		String userYear = request.getParameter("userYear");
		String userMonth = request.getParameter("userMonth");
		String userDay = request.getParameter("userDay");

		if (userGender.equals("m")) {
			model.addAttribute("manChecked", "checked");
		} else if (userGender.equals("w")) {
			model.addAttribute("womanChecked", "checked");
		}

		model.addAttribute("applicant", applicant);
		model.addAttribute("phoneNum", phoneNum);
		model.addAttribute("userName", userName);
		model.addAttribute("addr", addr);
		model.addAttribute("userGender", userGender);
		model.addAttribute("niText", niText);
		model.addAttribute("userYear", userYear);
		model.addAttribute("userMonth", userMonth);
		model.addAttribute("userDay", userDay);

		
	}

	public void taxiApply(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		// 문자인코딩형식
		request.setCharacterEncoding("UTF-8");
		String applicant = request.getParameter("applicant");
		String phoneNum = request.getParameter("phoneNum");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String startAddr = request.getParameter("startAddr");
		String endAddr = request.getParameter("endAddr");
		String tiText = request.getParameter("tiText");
		String userYear = request.getParameter("userYear");
		String userMonth = request.getParameter("userMonth");
		String userDay = request.getParameter("userDay");

		model.addAttribute("applicant", applicant);
		model.addAttribute("phoneNum", phoneNum);
		model.addAttribute("userName", userName);
		model.addAttribute("userGender", userGender);
		model.addAttribute("startAddr", startAddr);
		model.addAttribute("endAddr", endAddr);
		model.addAttribute("tiText", tiText);
		model.addAttribute("userYear", userYear);
		model.addAttribute("userMonth", userMonth);
		model.addAttribute("userDay", userDay);
		
	}













}

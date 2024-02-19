package com.halo.main.user.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.halo.main.admin.reservation.ReservationScheduleDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ServiceDAO {

	@Autowired
	ServiceMapper serviceMapper;

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
		String sa_service = (String) session.getAttribute("sa_service");
		String nextStep = null;
		// 불러온 데이터 사용 예시
		if (sa_service != null) {
			if (sa_service.equals("taxi")) {
				nextStep = "/service/apply/step4/taxiform";
			} else {
				nextStep = "/service/apply/step4/nursingform";
			}
			model.addAttribute("nextStep", nextStep);

			System.out.println("sa_service: " + sa_service);
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
		String sa_service = (String) session.getAttribute("sa_service");
		String nextStep = null;
		// 불러온 데이터 사용 예시
		if (sa_service != null) {

			if (sa_service.equals("nursingTaxi")) {
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

	public void goAgree(Model model) {
		model.addAttribute("serviceStep", "agree.jsp");
		model.addAttribute("step5Pos", "#ffdf6c");
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");

	}

	public void goComplet(Model model) {
		model.addAttribute("serviceStep", "complet.jsp");
		model.addAttribute("step6Pos", "#ffdf6c");
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");

	}

	public void svcSelect(HttpServletRequest request) {
		String sa_service = request.getParameter("sa_service");
		HttpSession session = request.getSession();
		session.setAttribute("sa_service", sa_service);
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

	public void serviceApply(ReservationScheduleDTO rsDTO, HttpServletRequest request) {
		
		String userYear = request.getParameter("sa_year");
		String userMonth = request.getParameter("sa_month");
		String userDay = request.getParameter("sa_days");
		String birthDate = userYear + "-" + userMonth + "-" + userDay;
		rsDTO.setSa_birth_date(birthDate);
		System.out.println(rsDTO.getSa_applicant());
		System.out.println(rsDTO.getSa_phone_number());
		System.out.println(rsDTO.getSa_user_name());
		System.out.println(rsDTO.getSa_gender());
		System.out.println(rsDTO.getSa_birth_date());
		System.out.println(rsDTO.getSa_year());
		System.out.println(rsDTO.getSa_month());
		System.out.println(rsDTO.getSa_days());
		System.out.println(rsDTO.getSa_time());
		System.out.println(rsDTO.getSa_addr());
		System.out.println(rsDTO.getSa_start_place());
		System.out.println(rsDTO.getSa_end_place());
		System.out.println(rsDTO.getSa_nursing_info());
		System.out.println(rsDTO.getSa_taxi_info());

		String selectedStart = request.getParameter("selectedStart");
		String selectedEnd = request.getParameter("selectedEnd");

		
		// 문자열을 LocalDate로 변환
		LocalDate startDate = LocalDate.parse(selectedStart);
		LocalDate endDate = LocalDate.parse(selectedEnd);
		
		// 각 날짜에서 연, 월, 일 추출
		int startYear = startDate.getYear();
		int startMonth = startDate.getMonthValue();

		int endYear = endDate.getYear();
		int endMonth = endDate.getMonthValue();
		String startDayDate = "";
		String endDayDate = "";
		String startMonthDate = "";
		String endMonthDate = "";
		String startYearDate = "";
		String endYearDate = "";
		for (LocalDate period = startDate; !period.isAfter(endDate); period = period.plusDays(1)) {
			int periodYear = period.getYear();
			int periodMonth = period.getMonthValue();
			int periodDay = period.getDayOfMonth();
			System.out.println(periodDay); // 날짜 출력 예시
			if (startMonth == periodMonth) {
				startDayDate += periodDay;
				if (startMonthDate.equals("")) {
					startMonthDate += periodMonth;
					startYearDate += periodYear;
				}
			}
			if (endMonth == periodMonth) {
				endDayDate += periodDay;
				if (endMonthDate.equals("")) {
					endMonthDate += periodMonth;
					endYearDate += periodYear;
				}
			}

			if (startMonth == endMonth) {
				if (!period.equals(endDate)) {
					startDayDate += ",";
				} else {
					break;
				}
			} else {

				if (startMonth == period.plusDays(1).getMonthValue()) {
					startDayDate += ",";

				}
				if (!period.equals(endDate)) {
					if (endMonth == periodMonth) {
						endDayDate += ",";
					}
				} else {
					break;
				}
			}

		}
		
		rsDTO.setSa_year(startYearDate);
		rsDTO.setSa_month(startMonthDate);
		rsDTO.setSa_days(startDayDate);
		
		System.out.println(rsDTO.getSa_applicant());
		System.out.println(rsDTO.getSa_phone_number());
		System.out.println(rsDTO.getSa_user_name());
		System.out.println(rsDTO.getSa_gender());
		System.out.println(rsDTO.getSa_birth_date());
		System.out.println(rsDTO.getSa_year());
		System.out.println(rsDTO.getSa_month());
		System.out.println(rsDTO.getSa_days());
		System.out.println(rsDTO.getSa_time());
		System.out.println(rsDTO.getSa_addr());
		System.out.println(rsDTO.getSa_start_place());
		System.out.println(rsDTO.getSa_end_place());
		System.out.println(rsDTO.getSa_nursing_info());
		System.out.println(rsDTO.getSa_taxi_info());
		
		// 세션 객체 가져오기
		HttpSession session = request.getSession();

		// 세션에서 데이터 불러오기
		rsDTO.setSa_service((String) session.getAttribute("sa_service"));
		if (serviceMapper.serviceApply(rsDTO) == 1) {
			System.out.println("신청 성공");
			if (!startMonthDate.equals(endMonthDate)) {
				rsDTO.setSa_year(endYearDate);
				rsDTO.setSa_month(endMonthDate);
				rsDTO.setSa_days(endDayDate);
				

				 if (serviceMapper.serviceApply(rsDTO) == 1) {
		                System.out.println("두 번째 신청 성공");
		            }

			}
		}
		;

	}

}

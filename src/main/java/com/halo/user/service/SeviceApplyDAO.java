package com.halo.user.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.halo.main.DBManagerhalo;

public class SeviceApplyDAO {
	private static Connection con = null;

	public static void svcSelect(HttpServletRequest request) {
		String selectedService = request.getParameter("service");

		HttpSession session = request.getSession();
		session.setAttribute("selectedService", selectedService);

		System.out.println(selectedService);
	}

	public static void calSelect(HttpServletRequest request) {
		String selectedStart = request.getParameter("selectedStart");
		String selectedEnd = request.getParameter("selectedEnd");

		System.out.println(selectedStart);
		System.out.println(selectedEnd);

		request.setAttribute("selectedStart", selectedStart);
		request.setAttribute("selectedEnd", selectedEnd);
	}

	public static void timeSelect(HttpServletRequest request) {

		String selectedTime = request.getParameter("selectedTime");

		System.out.println(selectedTime);

		request.setAttribute("selectedTime", selectedTime);
	}

	public static void nursingApply(HttpServletRequest request) throws IOException {
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
			request.setAttribute("manChecked", "checked");
		} else if (userGender.equals("w")) {
			request.setAttribute("womanChecked", "checked");
		}

		System.out.println(applicant);
		System.out.println(phoneNum);
		System.out.println(userName);
		System.out.println(userGender);
		System.out.println(addr);
		System.out.println(niText);
		System.out.println(userYear);
		System.out.println(userMonth);
		System.out.println(userDay);

		request.setAttribute("applicant", applicant);
		request.setAttribute("phoneNum", phoneNum);
		request.setAttribute("userName", userName);
		request.setAttribute("addr", addr);
		request.setAttribute("userGender", userGender);
		request.setAttribute("niText", niText);
		request.setAttribute("userYear", userYear);
		request.setAttribute("userMonth", userMonth);
		request.setAttribute("userDay", userDay);

	}

	public static void taxiApply(HttpServletRequest request) throws UnsupportedEncodingException {
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

		System.out.println(applicant);
		System.out.println(phoneNum);
		System.out.println(userName);
		System.out.println(userGender);
		System.out.println(userYear);
		System.out.println(userMonth);
		System.out.println(userDay);
		System.out.println(startAddr);
		System.out.println(endAddr);
		System.out.println(tiText);

		request.setAttribute("applicant", applicant);
		request.setAttribute("phoneNum", phoneNum);
		request.setAttribute("userName", userName);
		request.setAttribute("userGender", userGender);
		request.setAttribute("startAddr", startAddr);
		request.setAttribute("endAddr", endAddr);
		request.setAttribute("tiText", tiText);
		request.setAttribute("userYear", userYear);
		request.setAttribute("userMonth", userMonth);
		request.setAttribute("userDay", userDay);
	}

	public static void nursingTaxi(HttpServletRequest request) throws UnsupportedEncodingException {
		// 문자인코딩형식
		request.setCharacterEncoding("UTF-8");
		String applicant = request.getParameter("applicant");
		String phoneNum = request.getParameter("phoneNum");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userYear = request.getParameter("userYear");
		String userMonth = request.getParameter("userMonth");
		String userDay = request.getParameter("userDay");
		String addr = request.getParameter("addr");
		String startAddr = request.getParameter("startAddr");
		String endAddr = request.getParameter("endAddr");
		String niText = request.getParameter("niText");
		String tiText = request.getParameter("tiText");

		System.out.println(applicant);
		System.out.println(phoneNum);
		System.out.println(userName);
		System.out.println(userGender);
		System.out.println(userYear);
		System.out.println(userMonth);
		System.out.println(userDay);
		System.out.println(addr);
		System.out.println(startAddr);
		System.out.println(endAddr);
		System.out.println(niText);
		System.out.println(tiText);

		request.setAttribute("applicant", applicant);
		request.setAttribute("phoneNum", phoneNum);
		request.setAttribute("userName", userName);
		request.setAttribute("userGender", userGender);
		request.setAttribute("userYear", userYear);
		request.setAttribute("userMonth", userMonth);
		request.setAttribute("userDay", userDay);
		request.setAttribute("addr", addr);
		request.setAttribute("startAddr", startAddr);
		request.setAttribute("endAddr", endAddr);
		request.setAttribute("niText", niText);
		request.setAttribute("tiText", tiText);

	}

	public static void apply(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		try {

			String sql = "INSERT INTO reservation_information values(reservation_information_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'N', null, ?, ?, 'N', null,  SYSDATE )";
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			// 값 가져오기

			String applicant = request.getParameter("applicant");
			String phoneNum = request.getParameter("phoneNum");
			String userName = request.getParameter("userName");
			String userGender = request.getParameter("userGender");
			String userYear = request.getParameter("userYear");
			String userMonth = request.getParameter("userMonth");
			String userDay = request.getParameter("userDay");
			String birthDate = userYear + "-" + userMonth + "-" + userDay;
			String addr = request.getParameter("addr");
			String niText = request.getParameter("niText");
			String startAddr = request.getParameter("startAddr");
			String endAddr = request.getParameter("endAddr");
			String tiText = request.getParameter("tiText");
			String selectedTime = request.getParameter("selectedTime");

			String selectedStart = request.getParameter("selectedStart");
			String selectedEnd = request.getParameter("selectedEnd");

			System.out.println("???????????" + selectedStart);

			// 세션 객체 가져오기
			HttpSession session = request.getSession();

			// 세션에서 데이터 불러오기
			String selectedService = (String) session.getAttribute("selectedService");

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

			System.out.println(startDayDate);
			System.out.println(endDayDate);
			System.out.println(startMonthDate);
			System.out.println(endMonthDate);
			System.out.println(startYearDate);
			System.out.println(endYearDate);

			pstmt.setString(1, selectedService);
			pstmt.setString(2, applicant);
			pstmt.setString(3, phoneNum);
			pstmt.setString(4, userName);
			pstmt.setString(5, userGender);
			pstmt.setString(6, birthDate);
			pstmt.setString(7, startYearDate);
			pstmt.setString(8, startMonthDate);
			pstmt.setString(9, startDayDate);
			pstmt.setString(10, selectedTime);
			pstmt.setString(11, addr);
			pstmt.setString(12, startAddr);
			pstmt.setString(13, endAddr);
			pstmt.setString(14, niText);
			pstmt.setString(15, tiText);


			if (pstmt.executeUpdate() == 1) {
				System.out.println("신청성공");

				if (!startMonthDate.equals(endMonthDate)) {

					String sql2 = "INSERT INTO reservation_information values(reservation_information_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'N', null, ?, ?, 'N', null,  SYSDATE )";
					PreparedStatement pstmt2 = con.prepareStatement(sql2);

					pstmt2.setString(1, selectedService);
					pstmt2.setString(2, applicant);
					pstmt2.setString(3, phoneNum);
					pstmt2.setString(4, userName);
					pstmt2.setString(5, userGender);
					pstmt2.setString(6, birthDate);
					pstmt2.setString(7, endYearDate);
					pstmt2.setString(8, endMonthDate);
					pstmt2.setString(9, endDayDate);
					pstmt2.setString(10, selectedTime);
					pstmt2.setString(11, addr);
					pstmt2.setString(12, startAddr);
					pstmt2.setString(13, endAddr);
					pstmt2.setString(14, niText);
					pstmt2.setString(15, tiText);
					 if (pstmt2.executeUpdate() == 1) {
			                System.out.println("두 번째 신청 성공");
			            }

			            pstmt2.close();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("신청 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}

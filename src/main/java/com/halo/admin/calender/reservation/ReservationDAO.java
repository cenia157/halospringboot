package com.halo.admin.calender.reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halo.main.DBManagerhalo;

public class ReservationDAO {
	private static Connection con = null;

	public static void getAllReservationSchedule(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "select * from reservation_information";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<String> reservationSchedule = new ArrayList<String>();

			// 일정 객체 생성
			ReservationScheduleDTO schedule = null;

			// 객체에 데이터 추가
			while (rs.next()) {
				String no = rs.getString("sa_seq");
				String applicant = rs.getString("sa_applicant");
				String phoneNumber = rs.getString("sa_phone_number");
				String userName = rs.getString("sa_user_name");
				String gender = rs.getString("sa_gender");
				String birthDates = rs.getString("sa_birth_date");
				String year = rs.getString("sa_year");
				String month = rs.getString("sa_month");
				String dates = rs.getString("sa_days");
				String time = rs.getString("sa_time");
				String addr = rs.getString("sa_addr");
				String startPoint = rs.getString("sa_start_place");
				String endPoint = rs.getString("sa_end_place");
				String nurssingInfo = rs.getString("sa_nurssing_info");
				String taxiInfo = rs.getString("sa_taxi_info");
				String registrationDate = rs.getString("sa_registration_date");
				String service = rs.getString("sa_service");

				schedule = new ReservationScheduleDTO(no, applicant, phoneNumber, userName, gender, birthDates, year,
						month, dates, time, addr, startPoint, endPoint, nurssingInfo, taxiInfo, registrationDate,
						service);
				reservationSchedule.add(schedule.toJson());
			}

			System.out.println("예약 달력 조회 성공");
			response.getWriter().print(reservationSchedule);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("예약 달력 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public static void getReservationAcceptSchedule(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "select * from reservation_information_accept";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<String> reservationAccpectSchedule = new ArrayList<String>();

			// 일정 객체 생성
			ReservationScheduleAcceptDTO schedule = null;

			// 객체에 데이터 추가
			while (rs.next()) {
				String pkNo = rs.getString("sa_seq");
				String applicant = rs.getString("sa_applicant");
				String service = rs.getString("sa_service");
				String phoneNumber = rs.getString("sa_phone_number");
				String userName = rs.getString("sa_user_name");
				String gender = rs.getString("sa_gender");
				String birthDates = rs.getString("sa_birth_date");
				String year = rs.getString("sa_year");
				String month = rs.getString("sa_month");
				String dates = rs.getString("sa_days");
				String time = rs.getString("sa_time");
				String addr = rs.getString("sa_addr");
				String startPoint = rs.getString("sa_start_place");
				String endPoint = rs.getString("sa_end_place");
				String carNum = rs.getString("sa_car_no");
				String feedBack = rs.getString("sa_feedback");
				String registrationDate = rs.getString("sa_registration_date");
				String staff = rs.getString("sa_staff");
				String joinNo = rs.getString("sa_no");

				schedule = new ReservationScheduleAcceptDTO(pkNo, applicant, service, phoneNumber, userName, gender,
						birthDates, year, month, dates, time, addr, startPoint, endPoint, carNum, feedBack,
						registrationDate, staff, joinNo);
				reservationAccpectSchedule.add(schedule.toJson());
			}

			System.out.println("예약 확인 조회 성공");
			response.getWriter().print(reservationAccpectSchedule);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("예약 확인 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public static void deleteReservationSchedule(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "";

			if (request.getParameter("status").equals("accept") || request.getParameter("status").equals("decline")) {
				sql = "delete reservation_information where sa_seq = ?";
			} else if (request.getParameter("status").equals("delete")) {
				sql = "delete reservation_information_accept where sa_seq = ?";
			}

			System.out.println(request.getParameter("no"));

			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("예약 삭제 성공");
			}

		} catch (Exception e) {
			System.out.println("예약 삭제 실패");
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public static void getReservationStaffList(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "select * from staff_info";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<String> staffList = new ArrayList<String>();

			// 일정 객체 생성
			StaffDTO staff = null;

			// 객체에 데이터 추가
			while (rs.next()) {
				String name = rs.getString("s_name");

				staff = new StaffDTO(name);
				staffList.add(staff.toJson());
			}

			System.out.println("스태프 조회 성공");
			response.getWriter().print(staffList);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("스태프 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public static void reservationAgree(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			String sql = "";
			System.out.println(request.getParameter("status"));

			// 데이터베이스 연동
			if (request.getParameter("status").equals("accept")) {
				sql = "insert into reservation_information_accept values(reservation_information_accept_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			} else {
				sql = "insert into reservation_information_decline values(reservation_information_decline_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			}

			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			// Jackson ObjectMapper를 사용하여 JSON 문자열을 Map으로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, String> dataMap = objectMapper.readValue(request.getParameter("array"), Map.class);

			// 데이터 입력
			pstmt.setString(1, dataMap.get("applicant"));
			pstmt.setString(2, dataMap.get("service"));
			pstmt.setString(3, dataMap.get("phoneNumber"));
			pstmt.setString(4, dataMap.get("userName"));
			pstmt.setString(5, dataMap.get("gender"));
			pstmt.setString(6, dataMap.get("birthDates"));
			pstmt.setString(7, dataMap.get("year"));
			pstmt.setString(8, dataMap.get("month"));
			pstmt.setString(9, dataMap.get("dates"));
			pstmt.setString(10, dataMap.get("time"));
			pstmt.setString(11, dataMap.get("addr"));
			pstmt.setString(12, dataMap.get("startPoint"));
			pstmt.setString(13, dataMap.get("endPoint"));
			pstmt.setString(14, dataMap.get("carNum"));
			pstmt.setString(15, dataMap.get("feedBack"));
			pstmt.setString(16, dataMap.get("registrationDate"));
			pstmt.setString(17, dataMap.get("staff"));
			pstmt.setInt(18, Integer.parseInt(dataMap.get("no")));

			if (pstmt.executeUpdate() == 1) {
				if (request.getParameter("status").equals("accept")) {
					System.out.println("승인완료");
				} else {
					System.out.println("승인거절");
				}
				response.getWriter().print("true");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("승인실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}

	}

	public static void updateReservationAcceptSchedule(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "update reservation_information_accept set sa_service = ?, sa_user_name = ?, sa_days = ?, sa_addr = ?, sa_start_place = ?, sa_end_place = ?, sa_feedback = ?, sa_staff = ?, sa_phone_number = ?, sa_time = ?  where sa_seq = ?";

			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			// Jackson ObjectMapper를 사용하여 JSON 문자열을 Map으로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, String> dataMap = objectMapper.readValue(request.getParameter("object"), Map.class);

			// 데이터 입력
			pstmt.setString(1, dataMap.get("service"));
			pstmt.setString(2, dataMap.get("userName"));
			pstmt.setString(3, dataMap.get("dates"));
			pstmt.setString(4, dataMap.get("addr"));
			pstmt.setString(5, dataMap.get("startPoint"));
			pstmt.setString(6, dataMap.get("endPoint"));
			pstmt.setString(7, dataMap.get("feedBack"));
			pstmt.setString(8, dataMap.get("staff"));
			pstmt.setString(9, dataMap.get("phoneNumber"));
			pstmt.setString(10, dataMap.get("time"));
			pstmt.setString(11, dataMap.get("pkNo"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("수정완료");
				response.getWriter().print("true");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}

	}

	public static void passToReservationScheduleDecline(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			System.out.println(request.getParameter("status"));

			// 데이터베이스 연동
			String sql = "insert into reservation_information_decline values(reservation_information_decline_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			// Jackson ObjectMapper를 사용하여 JSON 문자열을 Map으로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, String> dataMap = objectMapper.readValue(request.getParameter("array"), Map.class);

			// 데이터 입력
			pstmt.setString(1, dataMap.get("applicant"));
			pstmt.setString(2, dataMap.get("service"));
			pstmt.setString(3, dataMap.get("phoneNumber"));
			pstmt.setString(4, dataMap.get("userName"));
			pstmt.setString(5, dataMap.get("gender"));
			pstmt.setString(6, dataMap.get("birthDates"));
			pstmt.setString(7, dataMap.get("year"));
			pstmt.setString(8, dataMap.get("month"));
			pstmt.setString(9, dataMap.get("dates"));
			pstmt.setString(10, dataMap.get("time"));
			pstmt.setString(11, dataMap.get("addr"));
			pstmt.setString(12, dataMap.get("startPoint"));
			pstmt.setString(13, dataMap.get("endPoint"));
			pstmt.setString(14, dataMap.get("carNum"));
			pstmt.setString(15, dataMap.get("feedBack"));
			pstmt.setString(16, dataMap.get("registrationDate"));
			pstmt.setString(17, dataMap.get("staff"));
			pstmt.setInt(18, Integer.parseInt(dataMap.get("joinNo")));

			if (pstmt.executeUpdate() == 1) {
//				if (request.getParameter("status").equals("accept")) {
				System.out.println("승인->거절");
//				} else {
//					System.out.println("승인거절");
//				}
				response.getWriter().print("true");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("승인실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public static void insertReservation(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			System.out.println(request.getParameter("status"));

			// 데이터베이스 연동
			String sql = "insert into reservation_information_accept values(reservation_information_accept_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			// Jackson ObjectMapper를 사용하여 JSON 문자열을 Map으로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, String> dataMap = objectMapper.readValue(request.getParameter("array"), Map.class);
			
			System.out.println(dataMap);
			
			// 데이터 입력
			pstmt.setString(1, dataMap.get("applicant"));
			pstmt.setString(2, dataMap.get("service"));
			pstmt.setString(3, dataMap.get("phoneNum"));
			pstmt.setString(4, dataMap.get("userName"));
			pstmt.setString(5, dataMap.get("gender"));
			pstmt.setString(6, dataMap.get("birthDates"));
			pstmt.setString(7, dataMap.get("year"));
			pstmt.setString(8, dataMap.get("month"));
			pstmt.setString(9, dataMap.get("dates"));
			pstmt.setString(10, dataMap.get("time"));
			pstmt.setString(11, dataMap.get("addr"));
			pstmt.setString(12, dataMap.get("startPoint"));
			pstmt.setString(13, dataMap.get("endPoint"));
			pstmt.setString(14, dataMap.get("carNum"));
			pstmt.setString(15, dataMap.get("feedBack"));
			pstmt.setString(16, dataMap.get("registrationDate"));
			pstmt.setString(17, dataMap.get("staff"));
			pstmt.setInt(18, 999);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("신규예약 등록 성공");
				response.getWriter().print("true");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("신규예약 등록 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

}

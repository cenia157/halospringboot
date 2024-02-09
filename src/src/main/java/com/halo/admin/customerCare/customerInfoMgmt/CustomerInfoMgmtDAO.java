package com.halo.admin.customerCare.customerInfoMgmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.admin.calender.reservation.ReservationScheduleAcceptDTO;
import com.halo.admin.calender.reservation.ReservationScheduleDTO;
import com.halo.admin.manager.staff.StaffDTO;
import com.halo.main.DBManagerhalo;

public class CustomerInfoMgmtDAO {
	private static Connection con = null;
	public static void getAllCustomerInfo(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "select * from reservation_information_accept order by sa_seq desc ";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<String> reservationSchedule = new ArrayList<String>();

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

}

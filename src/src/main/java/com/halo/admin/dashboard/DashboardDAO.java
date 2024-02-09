package com.halo.admin.dashboard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.admin.boardmanagement.ask.QuestionNComment;
import com.halo.admin.calender.company.CompanyScheduleDTO;
import com.halo.admin.calender.reservation.ReservationScheduleAcceptDTO;
import com.halo.main.DBManagerhalo;

public class DashboardDAO {
	// 대쉬보드 객체생성
	private DashboardDTO dDTO;

	private static Connection con = null;

	public void getReservationAcceptSchedule(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "select * from reservation_information_accept where sa_year like ? and  sa_month like ?";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("year"));
			pstmt.setString(2, request.getParameter("month"));

			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<ReservationScheduleAcceptDTO> reservationAccpectSchedule = new ArrayList<ReservationScheduleAcceptDTO>();

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
				reservationAccpectSchedule.add(schedule);
			}

			dDTO.setReservationAccpectSchedule(reservationAccpectSchedule);

			System.out.println("예약 확인 조회 성공");
//			response.getWriter().print(reservationAccpectSchedule);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("예약 확인 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public void getAllFAQ(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "SELECT q.*, c.* FROM question_tbl q LEFT JOIN comment_tbl c ON q.q_seq = c.q_seq WHERE c.c_answer IS NULL ORDER BY q.q_reg_date";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<QuestionNComment> unAnswered = new ArrayList<QuestionNComment>();

			// 일정 객체 생성
			QuestionNComment unAnsweredNotice = null;

			// 객체에 데이터 추가
			while (rs.next()) {
				unAnsweredNotice = new QuestionNComment();
				unAnsweredNotice.setQ_seq(rs.getInt("q_seq"));
				unAnsweredNotice.setQ_title(rs.getString("q_title"));
				unAnsweredNotice.setQ_content(rs.getString("q_content"));
				unAnsweredNotice.setQ_reg_date(rs.getDate("q_reg_date"));
				unAnsweredNotice.setQ_contact_number(rs.getString("q_contact_number"));
				unAnsweredNotice.setQ_email(rs.getString("q_email"));
				unAnsweredNotice.setQ_name(rs.getString("q_name"));
				unAnsweredNotice.setQ_password(rs.getString("q_password"));
				unAnsweredNotice.setQ_category(rs.getString("q_category"));

				// Comment
				unAnsweredNotice.setC_seq(rs.getInt("c_seq"));
				unAnsweredNotice.setC_commenter_name("c_commenter_name");
				unAnsweredNotice.setC_comment_content("c_comment_content");
				unAnsweredNotice.setC_reg_date(rs.getDate("c_reg_date"));
				unAnsweredNotice.setC_answer(rs.getString("c_answer"));

				unAnswered.add(unAnsweredNotice);
			}

			dDTO.setUnAnswered(unAnswered);

			System.out.println("미답변 문의 조회 성공");
//			response.getWriter().print(reservationAccpectSchedule);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("미답변 문의 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public void getCompanySchedule(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "select * from company_schedule where cs_year like ? and  cs_month like ?";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("year"));
			pstmt.setString(2, request.getParameter("month"));

			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<CompanyScheduleDTO> companySchedule = new ArrayList<CompanyScheduleDTO>();

			// 일정 객체 생성
			CompanyScheduleDTO schedule = null;

			// 객체에 데이터 추가
			while (rs.next()) {
				String year = rs.getString("cs_year");
				String month = rs.getString("cs_month");
				String title = rs.getString("cs_title");
				String txt = rs.getString("cs_txt");
				String date = rs.getString("cs_date");
				String update = rs.getString("cs_update");
				String no = rs.getString("cs_no");

				schedule = new CompanyScheduleDTO(year, month, title, txt, date, update, no);
				companySchedule.add(schedule);
			}

			dDTO.setCompanySchedule(companySchedule);

			System.out.println("회사 일정 조회 성공");
//			response.getWriter().print(reservationAccpectSchedule);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회사 일정 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public void getEmployeer(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "select * from staff_sift left outer join staff_info on s_no = f_staffno where f_month = ?";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("month"));
			
			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<DashboardStaffDTO> companySchedule = new ArrayList<DashboardStaffDTO>();

			// 일정 객체 생성
			DashboardStaffDTO sift = null;

			// 객체에 데이터 추가
			while (rs.next()) {
				int no = rs.getInt("f_no");
				String year = rs.getString("f_year");
				String month = rs.getString("f_month");
				String dates = rs.getString("f_dates");
				String position = rs.getString("s_position");
				String name = rs.getString("s_name");
				String phoneNo = rs.getString("s_phone_num");
				String addr = rs.getString("s_addr");

				sift = new DashboardStaffDTO(no, year, month, dates, position, name, phoneNo, addr);
				companySchedule.add(sift);
			}

			dDTO.setStaffSchedule(companySchedule);

			System.out.println("스태프 일정 조회 성공");
//			response.getWriter().print(reservationAccpectSchedule);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("스태프 일정 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public void sendObject(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(dDTO.toJson());

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			dDTO = new DashboardDTO();
			
			getReservationAcceptSchedule(request, response);
			getAllFAQ(request, response);
			getCompanySchedule(request, response);
			getEmployeer(request, response);

			response.getWriter().write(dDTO.toJson());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

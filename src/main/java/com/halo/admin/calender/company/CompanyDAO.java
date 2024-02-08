package com.halo.admin.calender.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.halo.main.DBManagerhalo;

public class CompanyDAO {
	private static Connection con = null;

	public static void getAllCompanySchedule(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "select * from company_schedule";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 일정 배열 생성
			ArrayList<String> companySchedule = new ArrayList<String>();

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
				companySchedule.add(schedule.toJson());

			}

			System.out.println("회사 달력 조회 성공");
			response.getWriter().print(companySchedule);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Company 달력 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}

	}

	public static void insertCompanySchedule(HttpServletRequest request) {
		PreparedStatement pstmt = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");

			// 날짜 객체생성
			LocalDateTime now = LocalDateTime.now();

			// 데이터베이스 연동
			String sql = "insert into company_schedule values(company_schedule_seq.nextval, ?, ?, ?, ?, ?, ?)";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			// 날짜 파라미터 요청
			String inputDates = request.getParameter("input-date");

			// 날짜 파라미터 연 / 월 / 일 로 분할
			int selectYearMonthPlace = inputDates.indexOf("月") + 1;
			String inputYear = inputDates.substring(0, inputDates.indexOf("年"));
			String inputMonth = inputDates.substring(inputDates.indexOf("年") + 2, inputDates.indexOf("月"));
			String selectDates = inputDates.substring(selectYearMonthPlace + 1, inputDates.length());

			pstmt.setString(1, inputYear);
			pstmt.setString(2, inputMonth);
			pstmt.setString(3, request.getParameter("input-title"));
			pstmt.setString(4, request.getParameter("input-txt"));
			pstmt.setString(5, selectDates);
			pstmt.setString(6, now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("일정추가 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("일정추가 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	public static void updateScheduleCompanyTxt(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");

			// 데이터베이스 연동
			String sql = "Update company_schedule set cs_txt = ? where cs_no = ?";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("txt"));
			pstmt.setString(2, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("내용 업데이트 완료");
				response.getWriter().print(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("내용 업데이트 실패");

			try {
				response.getWriter().print(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	public static void deleteScheduleCompanyDate(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");

			// 데이터베이스 연동
			String sql = "Update company_schedule set cs_date = ? where cs_no = ?";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			System.out.println(request.getParameter("remainDate"));

			pstmt.setString(1, request.getParameter("remainDate"));
			pstmt.setString(2, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 완료");
				response.getWriter().print(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패");

			try {
				response.getWriter().print(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}
	}

	public static void deleteRowScheduleCompanyDate(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");

			// 데이터베이스 연동
			String sql = "delete from company_schedule where cs_no = ?";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			System.out.println(request.getParameter("no"));

			pstmt.setString(1, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 완료");
				response.getWriter().print(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패");

			try {
				response.getWriter().print(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}
	}

}

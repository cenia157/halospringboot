package com.halo.admin.calender.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.admin.manager.staff.StaffDTO;
import com.halo.main.DBManagerhalo;

public class EmployeeDAO {
	private static Connection con = null;

	public static void getAllEmployeer(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "SELECT s_no, s_position, s_name, s_phone_num, TO_CHAR(s_entry_date, 'YYYY-MM-DD') as s_entry_date, s_color, s_addr FROM staff_info order by s_entry_date desc";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 직원 배열 생성
			ArrayList<String> staffInfo = new ArrayList<String>();

			// 직원 객체 생성
			StaffDTO staff = null;
			// 객체에 데이터 추가
			while (rs.next()) {
				int no = rs.getInt("s_no");
				String pos = rs.getString("s_position");
				String name = rs.getString("s_name");
				String phoneNum = rs.getString("s_phone_num");
				String entryDate = rs.getString("s_entry_date");
				String color = rs.getString("s_color");
				String addr = rs.getString("s_addr");

				staff = new StaffDTO(no, pos, name, phoneNum, entryDate, color, addr);
				staffInfo.add(staff.toJson());
			}

			System.out.println("직원 정보 조회 성공");
			response.getWriter().print(staffInfo);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("직원 정보 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}

	}

	public static void getAllsift(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "SELECT * from staff_sift";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 직원 배열 생성
			ArrayList<String> siftInfo = new ArrayList<String>();

			// 직원 객체 생성
			siftDTO sift = null;
			// 객체에 데이터 추가
			while (rs.next()) {
				int no = rs.getInt("f_no");
				String year = rs.getString("f_year");
				String month = rs.getString("f_month");
				String dates = rs.getString("f_dates");
				int staffNo = rs.getInt("f_staffNo");

				sift = new siftDTO(no, year, month, dates, staffNo);
				siftInfo.add(sift.toJson());
			}

			System.out.println("시프트 정보 조회 성공");
			response.getWriter().print(siftInfo);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("시프트 정보 조회 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}

	}

	public static void insertSift(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println(request.getParameter("f_year"));
		System.out.println(request.getParameter("f_month"));
		System.out.println(request.getParameter("f_dates"));
		System.out.println(request.getParameter("s_no"));

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "INSERT INTO staff_sift VALUES (staff_sift_seq.nextval, ?, ?, ?, ?)";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("f_year"));
			pstmt.setString(2, request.getParameter("f_month"));
			pstmt.setString(3, request.getParameter("f_dates"));
			pstmt.setInt(4, Integer.parseInt(request.getParameter("s_no")));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("시프트 입력 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("시프트 입력 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}

	}
	
	public static void updateSift(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println(request.getParameter("f_dates"));
		System.out.println(request.getParameter("f_no"));

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "Update staff_sift set f_dates = ? where f_no = ?";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("f_dates"));
			pstmt.setInt(2, Integer.parseInt(request.getParameter("f_no")));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("시프트 업데이트 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("시프트 업데이트 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}

	}

	public static void deleteSift(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "delete staff_sift where f_no = ?";

			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(request.getParameter("f_no")));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("시프트 삭제 성공");
			}

		} catch (Exception e) {
			System.out.println("시프트 삭제 실패");
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

}

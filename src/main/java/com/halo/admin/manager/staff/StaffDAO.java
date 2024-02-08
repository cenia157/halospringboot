package com.halo.admin.manager.staff;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.halo.main.DBManagerhalo;

public class StaffDAO {
	private static Connection con = null;

	public static void getAllStaffList(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");

			// 데이터베이스 연동
			String sql = "SELECT s_no, s_position, s_name, s_phone_num, TO_CHAR(s_entry_date, 'YYYY-MM-DD') as s_entry_date, s_color, s_addr FROM staff_info order by s_entry_date desc, s_no desc";
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

//			    System.out.println(no);
//			    System.out.println(name);
//			    System.out.println(phoneNum);
//			    System.out.println(entryDate);
//			    System.out.println(color);
//			    System.out.println(addr);
//			    System.out.println("------------");

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

	public static void staffReg(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		try {
			// 문자인코딩형식
			request.setCharacterEncoding("UTF-8");

			String sql = "insert into staff_info values(staff_info_seq.nextval, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			
			String inputDate = request.getParameter("input-staff-entryDate");
			
			System.out.println(request.getParameter("input-staff-name"));
			System.out.println(request.getParameter("input-staff-pos"));
			System.out.println(request.getParameter("input-staff-callNum"));
			System.out.println(request.getParameter("input-steff-addr"));
			System.out.println("request.getParameter(\"input-staff-entryDate\") : "+request.getParameter("input-staff-entryDate"));
			System.out.println(request.getParameter("input-staff-color"));
			
			
			
			
			pstmt.setString(1, request.getParameter("input-staff-pos"));
			pstmt.setString(2, request.getParameter("input-staff-name"));
			pstmt.setString(3, request.getParameter("input-staff-callNum"));
			pstmt.setString(4, request.getParameter("input-staff-entryDate"));
			pstmt.setString(5, request.getParameter("input-staff-color"));
			pstmt.setString(6, request.getParameter("input-steff-addr"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("직원 정보 추가 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("직원 정보 추가 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	public static void staffUpdate(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		
		try {
			request.setCharacterEncoding("UTF-8");
		StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        JSONParser parser = new JSONParser();
            Object obj = parser.parse(sb.toString());
            JSONObject jsonObject = (JSONObject) obj;

            String s_position = (String) jsonObject.get("s_position");
            String s_name = (String) jsonObject.get("s_name");
            String s_phone_num = (String) jsonObject.get("s_phone_num");
            String s_entry_date = (String) jsonObject.get("s_entry_date");
            String s_color = (String) jsonObject.get("s_color");
            String s_addr = (String) jsonObject.get("s_addr");
            String s_no = (String) jsonObject.get("s_no");
            System.out.println(s_position);
            System.out.println(s_name);
            System.out.println(s_phone_num);
            System.out.println(s_entry_date);
            System.out.println(s_color);
            System.out.println(s_addr);
            System.out.println(s_no);
            	
            
         // 문자인코딩형식

         	        String sql = "UPDATE staff_info " +
                            "SET s_position = ?, " +
                            "    s_name = ?, " +
                            "    s_phone_num = ?, " +
                            "    s_entry_date = TO_DATE(?, 'YYYY-MM-DD'), " +
                            "    s_color = ?, " +
                            "    s_addr = ? " +
                            "WHERE s_no = ?";
         	        
         			con = DBManagerhalo.connect();
         			pstmt = con.prepareStatement(sql);
         			
         			pstmt.setString(1, s_position);
         			pstmt.setString(2, s_name);
         			pstmt.setString(3, s_phone_num);
         			pstmt.setString(4, s_entry_date);
         			pstmt.setString(5, s_color);
         			pstmt.setString(6, s_addr);
         			pstmt.setString(7, s_no);

         			if (pstmt.executeUpdate() == 1) {
         				System.out.println("직원 정보 수정 성공");
         			}
            



		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("직원 정보 추가 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}
		
		
	}

	public static void staffDelete(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		try {
			request.setCharacterEncoding("UTF-8");
		StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        JSONParser parser = new JSONParser();
            Object obj = parser.parse(sb.toString());
            JSONObject jsonObject = (JSONObject) obj;

            String s_position = (String) jsonObject.get("s_position");
            String s_name = (String) jsonObject.get("s_name");
            String s_phone_num = (String) jsonObject.get("s_phone_num");
            String s_entry_date = (String) jsonObject.get("s_entry_date");
            String s_color = (String) jsonObject.get("s_color");
            String s_addr = (String) jsonObject.get("s_addr");
            String s_no = (String) jsonObject.get("s_no");
            System.out.println(s_position);
            System.out.println(s_name);
            System.out.println(s_phone_num);
            System.out.println(s_entry_date);
            System.out.println(s_color);
            System.out.println(s_addr);
            System.out.println(s_no);
            	
            
         // 문자인코딩형식

         	        String sql = "DELETE staff_info WHERE s_no = ?";
         	        
         			con = DBManagerhalo.connect();
         			pstmt = con.prepareStatement(sql);
         			

         			pstmt.setString(1, s_no);

         			if (pstmt.executeUpdate() == 1) {
         				System.out.println("직원 정보 삭제 성공");
         			}
            

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("직원 정보 삭제 실패");
		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}
		
	}

}

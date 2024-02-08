package com.halo.admin.boardmanagement.frequenthyask;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halo.main.DBManagerhalo;

public class FAQDAO {

	private static ArrayList<FAQ> FAQs;
	
	public static void getAllFAQ(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "select * from QA_tbl order by qa_seq ASC";
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			FAQs = new ArrayList<>();
			FAQ faq;
			
			while (rs.next()) {
				int qa_seq = rs.getInt("qa_seq");
				String qa_title = rs.getString("qa_title");
				String qa_content = rs.getString("qa_content");
				Date qa_reg_date = rs.getDate("qa_reg_date");
			
			faq = new FAQ(qa_seq, qa_title, qa_content, qa_reg_date); 
			FAQs.add(faq);
			}
			
			request.setAttribute("FAQs", FAQs);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		
		
	}
	
	public static void FAQpagingAdmin(int page, HttpServletRequest request) {
		
		request.setAttribute("curPageNo", page);
		System.out.println("page: " + page);
		
		int cnt = 8; 
		int total = FAQs.size(); 
		System.out.println("total ::: " + total );
		int pageCount = (int)Math.ceil((double)total / cnt);
		request.setAttribute("pageCount", pageCount);
		System.out.println("pageCount: "+pageCount);
		
		int start = total - (cnt * (page -1));
		System.out.println("start ::: " + start );
		
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<FAQ> items = new ArrayList<FAQ>();
		
		
		for (int i = start-1; i > end; i--) {
			items.add(FAQs.get(i));
		}
		
		request.setAttribute("FAQs", items);
		
	}
	
	public static void getFAQDetail(HttpServletRequest request, HttpServletResponse response) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM QA_tbl WHERE qa_seq = ?";
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("qa_seq"));
			System.out.println("QA seq: "+request.getParameter("qa_seq"));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				FAQ FAQ = new FAQ();
				
				FAQ.setQa_seq(rs.getInt("qa_seq"));
				FAQ.setQa_title(rs.getString("qa_title"));
				FAQ.setQa_content(rs.getString("qa_content"));
				FAQ.setQa_reg_date(rs.getDate("qa_reg_date"));

				request.setAttribute("FAQ", FAQ );
				System.out.println("FAQ값 확인: "+ FAQ);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}
	
	
	public static String FAQList (HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FAQ> FAQList = new ArrayList<FAQ>();
		String jsonresult = null;
		
		int qa_seq = 0;
		String qa_title = null;
		String qa_content = null;
		Date qa_reg_date = null;
		
		String sql = "SELECT * FROM QA_tbl WHERE qa_seq = ?";
		response.setContentType("application/json");
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("qa_seq"));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			qa_seq = rs.getInt(1);
			qa_title = rs.getString(2);
			qa_content = rs.getString(3);
			qa_reg_date = rs.getDate(4);
			
			FAQ faq = new FAQ(qa_seq, qa_title, qa_content, qa_reg_date);
			FAQList.add(faq);
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			jsonresult = objectMapper.writeValueAsString(FAQList);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		
		return jsonresult;
		
	}

	//CRUD: 삭제

	public static void deleteFAQ(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM QA_tbl WHERE qa_seq = ?";
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("qa_seq"));
			System.out.println("삭제될 번호: " + request.getParameter("qa_seq"));
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("FAQ 삭제 완료");
			}
			
		} catch (Exception e) {
			System.out.println("FAQ 삭제 실패");
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}
		
		
	}
	
	
	
}
	




	

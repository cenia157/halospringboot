package com.halo.admin.boardmanagement.notice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halo.main.DBManagerhalo;

public class Notice {

	private static ArrayList<NoticeDTO> notices;

	public static void getAllNotice(HttpServletRequest request, HttpServletResponse response) {
		
//		// 기존코드 시작
//		// 체크박스 벨류
//		System.out.println("여기 들어왔나 확인 ");
//		String checkBoxVal[] = {"announcement","schedule","general","service","product"};
//		String checkVal = request.getParameter("checkVal");
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select * from ANNOUNCED_TBL where ";
//		for (int i = 0; i < checkVal.length(); i++) {
//			int checkValIndex = Integer.parseInt(Character.toString(checkVal.charAt(i)));
//			sql += "an_category = '" + checkBoxVal[checkValIndex]+"' ";
//			if(i != checkVal.length()-1) {
//				sql += " or ";
//			}
//		}
//		sql += " order by an_seq ASC";
//		System.out.println(sql);
//		try {
//			con = DBManagerhalo.connect();
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			notices = new ArrayList<Notice>();
//			Notice notice = null;
//
//			while (rs.next()) {
//				int an_seq = rs.getInt("an_seq");
//				String an_title = rs.getString("an_title");
//				String an_content = rs.getString("an_content");
//				String an_writer = rs.getString("an_writer");
//				Date an_reg_date = rs.getDate("an_reg_date");
//				String an_category = rs.getString("an_category");
//				
//				notice = new Notice(an_seq, an_title, an_content, an_writer, an_reg_date, an_category);
//				notices.add(notice);
//			}
//
//			request.setAttribute("notices", notices);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManagerhalo.close(con, pstmt, rs);
//		}
//		// 기존코드 끝
		
		// 수정코드 시작 
	    // 체크박스 값 파싱
	    String checkBoxVal[] = {"announcement", "schedule", "general", "service", "product"};
	    String checkVal = request.getParameter("checkVal");
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM ANNOUNCED_TBL WHERE ");
	    List<Integer> params = new ArrayList<>();

	    for (int i = 0; i < checkVal.length(); i++) {
	        int checkValIndex = Character.getNumericValue(checkVal.charAt(i));
	        if (i > 0) {
	            sqlBuilder.append(" OR ");
	        }

	        sqlBuilder.append("an_category = ?");
	        params.add(checkValIndex);
	    }

	    sqlBuilder.append(" ORDER BY an_seq ASC");
	    String sql = sqlBuilder.toString();

	    try {
	        con = DBManagerhalo.connect();
	        pstmt = con.prepareStatement(sql);

	        for (int i = 0; i < params.size(); i++) {
	            pstmt.setString(i + 1, checkBoxVal[params.get(i)]);
	        }
	        rs = pstmt.executeQuery();
	        
	        notices = new ArrayList<>();
	        while (rs.next()) {
	            NoticeDTO notice = new NoticeDTO(
	                rs.getInt("an_seq"),
	                rs.getString("an_title"),
	                rs.getString("an_content"),
	                rs.getString("an_writer"),
	                rs.getDate("an_reg_date"),
	                rs.getString("an_category")
	            );
	            notices.add(notice);
	        }
	        request.setAttribute("notices", notices);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManagerhalo.close(con, pstmt, rs);
	    }
	   // 수정코드 끝 
	}

	public static String NOTICEList(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<NoticeDTO> NOTICEList = new ArrayList<NoticeDTO>();
		String jsonresult = null;

		int an_seq = 0;
		String an_title = null;
		String an_content = null;
		String an_writer = null;
		Date an_reg_date = null;
		String an_category = null;

		String sql = "SELECT * FROM ANNOUNCED_TBL WHERE an_seq = ?";
		response.setContentType("application/json");

		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("an_seq"));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				an_seq = rs.getInt(1);
				an_title = rs.getString(2);
				an_content = rs.getString(3);
				an_writer = rs.getString(4);
				an_reg_date = rs.getDate(5);
				an_category = rs.getString(6);

				NoticeDTO notice = new NoticeDTO(an_seq, an_title, an_content, an_writer, an_reg_date, an_category);

				NOTICEList.add(notice);
			}
			ObjectMapper objectMapper = new ObjectMapper();
			jsonresult = objectMapper.writeValueAsString(NOTICEList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		return jsonresult;

	}

	public static void noticePaging(int page, HttpServletRequest request) {

		int cnt = 8;
		int total = notices.size();
		int pageCount = (int) Math.ceil((double) total / cnt);
		if(pageCount < page ) {
			page = pageCount;
		}
			
			request.setAttribute("pageCount", pageCount);
		
		
		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<NoticeDTO> items = new ArrayList<NoticeDTO>();
		if(notices.size() != 0) {
			for (int i = start - 1; i > end; i--) {
				items.add(notices.get(i));
			}
		}
		request.setAttribute("curPageNo", page);
		request.setAttribute("notices", items);

	}

	public static void deleteNotice(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete announced_tbl where an_seq = ?"; 
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("an_seq"));
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("deleteNotice() 삭제 성공");
			}

		} catch (Exception e) {
			System.out.println("deleteNotice() 삭제 실패");
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, null);
	    }	
	}
}

package com.halo.user.introduce.announcement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.halo.main.DBManagerhalo;

import jakarta.servlet.http.HttpServletRequest;

public class AnnouncedDAO {
	
	private static ArrayList<Announced_tbl_DTO> announcements; // 추가
    
//	Connection con = null;
	
	/**
	 * 목록을 가져온다.
	 */
    public static void getAllAnnouncements(HttpServletRequest request) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM announced_tbl ORDER BY an_seq ASC";
        
        try {
            con = DBManagerhalo.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            announcements = new ArrayList<>();
            Announced_tbl_DTO announcement;

            while (rs.next()) {
                int an_seq = rs.getInt("an_seq");
                String an_title = rs.getString("an_title");
                String an_content = rs.getString("an_content");
                String an_writer = rs.getString("an_writer");
                Date an_reg_date = rs.getDate("an_reg_date");
                String an_category = rs.getString("an_category");
                String an_img = "default_image_path"; // 임시로 설정된 이미지 경로, 실제 이미지 경로로 변경 필요

                announcement = new Announced_tbl_DTO(an_seq, an_title, an_content, an_writer, an_reg_date, an_category, an_img);
                announcements.add(announcement);
            }
            request.setAttribute("announcements", announcements);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	DBManagerhalo.close(con,pstmt, rs);
        }
    }
    
    // Seo's method
    public static void getMainAnnouncements(HttpServletRequest request) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from (SELECT * FROM announced_tbl ORDER BY an_seq desc) where rownum<4";
        
        try {
            con = DBManagerhalo.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            ArrayList<Announced_tbl_DTO> announceArr = new ArrayList<Announced_tbl_DTO>();
            Announced_tbl_DTO announcement;

            while (rs.next()) {
                int an_seq = rs.getInt("an_seq");
                String an_title = rs.getString("an_title");
                StringBuilder an_content = new StringBuilder();
                an_content.append(rs.getString("an_content"));
                
                while (an_content.indexOf("<figure") != -1) {
                	an_content.replace(an_content.indexOf("<figure"), an_content.indexOf("</figure>") + 9, "");
                }
                
                String an_writer = rs.getString("an_writer");
                Date an_reg_date = rs.getDate("an_reg_date");
                String an_category = rs.getString("an_category");
                String an_img = "default_image_path"; // 임시로 설정된 이미지 경로, 실제 이미지 경로로 변경 필요

                announcement = new Announced_tbl_DTO(an_seq, an_title, an_content.toString().trim(), an_writer, an_reg_date, an_category, an_img);
                announceArr.add(announcement);
                System.out.println("모달컨텐트: "+an_content);
                
                
            }

            request.setAttribute("announcements", announceArr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	DBManagerhalo.close(con,pstmt, rs);
        }
    }
    
    /**
     * 모달을 보여줄 한건의 데이터 조회
     * @param request
     */
    public static void getAnnouncement(HttpServletRequest request) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM announced_tbl WHERE an_seq = ? ORDER BY an_seq DESC";

        int anSeq = Integer.parseInt(request.getParameter("an_seq"));
        
        try {
            con = DBManagerhalo.connect();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, anSeq);
            rs = pstmt.executeQuery();


            while (rs.next()) {
            	
            	String dateStr = rs.getString("an_reg_date");
            	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            	
            	request.setAttribute("writer", rs.getString("an_writer"));
            	request.setAttribute("title", rs.getString("an_title"));
            	request.setAttribute("content", rs.getString("an_content"));
            	request.setAttribute("dateStr", dateStr);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	DBManagerhalo.close(con, pstmt, rs);
        }
    }

	public static void paging(int page, HttpServletRequest request) {
		
		request.setAttribute("curPageNo", page);
		
		int cnt = 5; 
		int total = announcements.size(); 
//		System.out.println("total ::: " + total );
		int pageCount = (int)Math.ceil((double)total / cnt);
//		System.out.println("pageCount ::: " + pageCount );
		request.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt * (page -1));
//		System.out.println("start ::: " + start );
//		System.out.println("AAAAAAAAAA");
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<Announced_tbl_DTO> items = new ArrayList<Announced_tbl_DTO>();
		
		for (int i = start-1; i > end; i--) {
			items.add(announcements.get(i));
		}
		request.setAttribute("announcements", items);
	}
}

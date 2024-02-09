package com.halo.user.qa.question;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.main.DBManagerhalo;


@WebServlet("/QuestionMoveC")
public class QuestionMoveC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
	        PrintWriter out = response.getWriter();
	        
	        int currentPostId = Integer.parseInt(request.getParameter("postId"));
	        
	        try {
	            Class.forName("question_tbl"); // 데이터베이스 드라이버 클래스를 적절히 수정
	            Connection connection = DBManagerhalo.connect(); // 데이터베이스 연결 정보를 적절히 수정

	            // 이전 글과 다음 글의 제목을 가져오는 SQL 쿼리
	            String sql = "SELECT q_title FROM question_tbl WHERE q_seq = ?";

	            // 이전 글의 제목
	            String previousTitle = findClosestTitle(connection, sql, currentPostId, -1);

	            // 다음 글의 제목
	            String nextTitle = findClosestTitle(connection, sql, currentPostId, 1);

	            // JSON 형식으로 응답
	            System.out.println("{ \"previousTitle\": \"" + previousTitle + "\", \"nextTitle\": \"" + nextTitle + "\" }");

	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            out.println("{ \"error\": \"데이터를 가져오는 중 오류가 발생했습니다.\" }");
	        }
	    }

	private String findClosestTitle(Connection connection, String sql, int currentPostId, int direction)  {
	    String closestTitle = null;
	    int postIdToCheck = currentPostId + direction;

	    try {
	        while (postIdToCheck > 0) {
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setInt(1, postIdToCheck);
	                ResultSet result = statement.executeQuery();

	                if (result.next()) {
	                    closestTitle = result.getString("q_title");
	                    break;
	                }
	            }

	            postIdToCheck += direction;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // 예외를 처리하는 방식을 적절히 수정해야 합니다.
	    }

	    return closestTitle;
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

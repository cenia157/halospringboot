package com.halo.user.qa.question;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.halo.admin.boardmanagement.ask.QuestionNComment;
import com.halo.main.DBManagerhalo;

public class QuestionDAO {
	
	public static void questionSubmit(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into question_tbl values (question_tbl_seq.nextval, ?, ?, sysdate, ?, ?, ?, ?, ?)";
		
		try {

			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, Utility.escapeHtml(request.getParameter("q_title")));
			pstmt.setString(2, Utility.escapeHtml(request.getParameter("q_content")));
			pstmt.setString(3, Utility.escapeHtml(request.getParameter("q_contact_number")));
			pstmt.setString(4, Utility.escapeHtml(request.getParameter("q_email")));
			pstmt.setString(5, Utility.escapeHtml(request.getParameter("q_name")));
			pstmt.setString(6, Utility.escapeHtml(request.getParameter("q_password")));
			pstmt.setString(7, Utility.escapeHtml(request.getParameter("q_category")));
			
			
			
			if (pstmt.executeUpdate() ==1) {
				System.out.println("제출성공");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("제출실패");
		}finally {	
			DBManagerhalo.close(con, pstmt, null);
		}
		
	}
	
	public static void getAllQuestions(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from question_tbl order by q_reg_date desc";
		
		
		try {
				con = DBManagerhalo.connect();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				List<Question> questions = new ArrayList<>();

				while (rs.next()) {
					Question question = new Question();
					question.setQ_seq(Integer.parseInt(rs.getString("q_seq")));
					question.setQ_title(rs.getString("q_title"));
					question.setQ_content(rs.getString("q_content"));
					question.setQ_reg_date(rs.getDate("q_reg_date"));
					question.setQ_contact_number(rs.getString("q_contact_number"));
					question.setQ_email(rs.getString("q_email"));
					question.setQ_name(rs.getString("q_name"));
					question.setQ_password(rs.getString("q_password"));
					question.setQ_category(rs.getString("q_category"));
					
					questions.add(question);
				}
				
				request.setAttribute("questions", questions);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		
		
	}

	public static void getQuestionNComment(HttpServletRequest request) {
		
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		String sql = "SELECT q.*, c.*"
				+ " FROM question_tbl q"
				+ " LEFT JOIN comment_tbl c"
				+ " ON q.q_seq = c.q_seq"
				+ " WHERE q.q_seq = ?";

	    String q_seq = request.getParameter("q_seq");

	    try {
	        con = DBManagerhalo.connect();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, Integer.parseInt(q_seq));
	        
	        
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            QuestionNComment QnC = new QuestionNComment();
	            QnC.setQ_seq(rs.getInt("q_seq"));
	            QnC.setQ_title(rs.getString("q_title"));
	            QnC.setQ_content(rs.getString("q_content"));
	            QnC.setQ_reg_date(rs.getDate("q_reg_date"));
	            QnC.setQ_contact_number(rs.getString("q_contact_number"));
	            QnC.setQ_email(rs.getString("q_email"));
	            QnC.setQ_name(rs.getString("q_name"));
	            QnC.setQ_password(rs.getString("q_password"));
	            QnC.setQ_category(rs.getString("q_category"));
	            
	            QnC.setC_seq(rs.getInt("c_seq"));
	            QnC.setC_commenter_name(rs.getString("c_commenter_name"));
	            QnC.setC_comment_content(rs.getString("c_comment_content"));
	            QnC.setC_reg_date(rs.getDate("c_reg_date"));
	            QnC.setC_answer(rs.getString("c_answer"));

	            request.setAttribute("QnC", QnC);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManagerhalo.close(con, pstmt, rs);
	    }
	}

	public static String questionList(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Question> questionList = new ArrayList<>();
		String jsonResult = null;
		
		int q_seq = 0;
		String q_title = null;
		String q_content = null;
		Date q_reg_date = null;
		String q_contact_number = null;
		String q_email = null;
		String q_name = null;
		String q_password = null;
		String q_category = null;
		
		String sql = "select * from question_tbl where q_seq=?";
		response.setContentType("application/json");

		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("q_seq"));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				q_seq = rs.getInt(1);
				q_title = rs.getString(2);
				q_content = rs.getString(3);
				q_reg_date = rs.getDate(4);
				q_contact_number = rs.getString(5);
				q_email = rs.getString(6);
				q_name = rs.getString(7);
				q_password = rs.getString(8);
				q_category = rs.getString(9);
				
				Question question = new Question(q_seq, q_title, q_content, q_reg_date, q_contact_number, q_email, q_name, q_password, q_category);
                questionList.add(question);
				
	            try {
	            	ObjectMapper objectMapper = new ObjectMapper();
					jsonResult = objectMapper.writeValueAsString(questionList);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		return jsonResult;
	}
	
	
	public ArrayList<Question> questions() {
		String sql = "select from question_tbl";
		ArrayList<Question> questionsArray = new ArrayList<Question>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Question question = new Question();
	            question.setQ_seq(rs.getInt(1));
	            question.setQ_title(rs.getString(2));
	            question.setQ_content(rs.getString(3));
	            question.setQ_reg_date(rs.getDate(4));
	            question.setQ_contact_number(rs.getString(5));
	            question.setQ_email(rs.getString(6));
	            question.setQ_name(rs.getString(7));
	            question.setQ_password(rs.getString(8));
	            question.setQ_category(rs.getString(9));
	            
	            questionsArray.add(question);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		return questionsArray;
		
	}
	




	public static void deleteQuestionNComment(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmtQ = null;
		PreparedStatement pstmtC = null;
		
		try {
			con = DBManagerhalo.connect();

			// 먼저 comment_tbl에서 해당 q_seq 값을 가진 레코드 삭제
			String sqlC = "DELETE FROM comment_tbl WHERE q_seq=?";
			pstmtC = con.prepareStatement(sqlC);
			pstmtC.setInt(1, Integer.parseInt(request.getParameter("q_seq")));
			pstmtC.executeUpdate(); // comment_tbl에서 레코드 삭제

			// 이후 question_tbl에서 q_seq 값을 가진 레코드 삭제
			String sqlQ = "DELETE FROM question_tbl WHERE q_seq=?";
			pstmtQ = con.prepareStatement(sqlQ);
			pstmtQ.setInt(1, Integer.parseInt(request.getParameter("q_seq")));
			pstmtQ.executeUpdate(); // question_tbl에서 레코드 삭제

			
			if (pstmtQ.executeUpdate()==1) {
				System.out.println("Q삭제성공");
			} if (pstmtC.executeUpdate()==1) {
				System.out.println("C삭제성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패");
		} finally {
			DBManagerhalo.close(con, pstmtC, null);
		}
		
	}
	
	
//	페이징


	
    
}



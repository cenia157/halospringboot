package com.halo.admin.boardmanagement.ask;

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
import com.halo.main.DBManagerhalo;
import com.halo.user.qa.question.Utility;

public class AskDAO {

	private static ArrayList<QuestionNComment> QnCs;
	
	public static void AskAnswerSubmit(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into comment_tbl (c_seq, c_commenter_name, c_comment_content, c_reg_date, c_answer, q_seq)"
				+ " values (comment_tbl_seq.nextval, ?, ?, sysdate, ?,?)";
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			System.out.println("작성자: "+ request.getParameter("c_writer"));
			pstmt.setString(1, request.getParameter("c_writer"));
			pstmt.setString(2, Utility.escapeHtml(request.getParameter("c_comment_content")));
			pstmt.setString(3, "1");
			pstmt.setString(4, request.getParameter("q_seq"));

			
			if (pstmt.executeUpdate()==1) {
				System.out.println("코멘트 성공");
			} else {
				System.err.println("코멘트 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManagerhalo.close(con, pstmt, null);
		}
	}
	
	public static void AskAnswerUpdate(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update comment_tbl set c_comment_content = ? where c_seq=?";
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("c_comment_content"));
			pstmt.setString(2, request.getParameter("c_seq"));
			
			
			if (pstmt.executeUpdate()==1) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, null);
		}
		
		
		
	}
	
	
	//답변여부
	public static void AskAnswerYorN(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "select c_answer from comment_tbl where q_seq = ?";
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("q_seq"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String cAnswer = rs.getString("c_answer");
			}
			
			if (pstmt.executeUpdate()==1) {
				System.out.println("answer 값 변환 성공");
			}else {
				System.out.println("answer 값 변환 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}
	
	
	public static String commentList(HttpServletRequest request, HttpServletResponse response) {
		 Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        ArrayList<Comment> commentList = new ArrayList<>();
	        String jsonResult = null;


	        try {
	            con = DBManagerhalo.connect();
	            System.out.println("댓글조회 시도");
	            // 댓글 조회 SQL
	            String sql = "SELECT * FROM comment_tbl WHERE q_seq = ?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, request.getParameter("q_seq"));

	            rs = pstmt.executeQuery();

	            while (rs.next()) {
	                int cSeq = rs.getInt("c_seq");
	                String cCommenterName = rs.getString("c_commenter_name");
	                String cCommentContent = rs.getString("c_comment_content");
	                Date cRegDate = rs.getDate("c_reg_date");
	                String cAnswer = rs.getString("c_answer");
	                int qSeq = rs.getInt("q_seq");

	                Comment comment = new Comment(cSeq, cCommenterName, cCommentContent, cRegDate, cAnswer, qSeq);
	                commentList.add(comment);
	            }

	            // 댓글 리스트를 JSON 형태로 변환
	            ObjectMapper objectMapper = new ObjectMapper();
	            jsonResult = objectMapper.writeValueAsString(commentList);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
				DBManagerhalo.close(con, pstmt, rs);
			}

	        return jsonResult;
	    }
		
	
	public static List<QuestionNComment> QuestionsAndComments () {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT q.*, c.*"
				+ " FROM question_tbl q"
				+ " LEFT JOIN comment_tbl c"
				+ " ON q.q_seq = c.q_seq"
				+ " ORDER BY q.q_reg_date";
		
		List<QuestionNComment> resultList = new ArrayList<QuestionNComment>();
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				QuestionNComment questionNComment = new QuestionNComment();

				//Question
				questionNComment.setQ_seq(rs.getInt("q_seq"));
				questionNComment.setQ_title(rs.getString("q_title"));
				questionNComment.setQ_content(rs.getString("q_content"));
				questionNComment.setQ_reg_date(rs.getDate("q_reg_date"));
				questionNComment.setQ_contact_number(rs.getString("q_contact_number"));
				questionNComment.setQ_email(rs.getString("q_email"));
				questionNComment.setQ_name(rs.getString("q_name"));
				questionNComment.setQ_password(rs.getString("q_password"));
				questionNComment.setQ_category(rs.getString("q_category"));
				
				//Comment
				questionNComment.setC_seq(rs.getInt("c_seq"));
				questionNComment.setC_commenter_name("c_commenter_name");
				questionNComment.setC_comment_content("c_comment_content");
				questionNComment.setC_reg_date(rs.getDate("c_reg_date"));
				questionNComment.setC_answer(rs.getString("c_answer"));
				
				resultList.add(questionNComment);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		
		return resultList;
		
	}

	
	
	public static void getAllQnC(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "SELECT q.*, c.*"
				+ " FROM question_tbl q"
				+ " LEFT JOIN comment_tbl c"
				+ " ON q.q_seq = c.q_seq"
				+ " ORDER BY q.q_reg_date";
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			QnCs = new ArrayList<QuestionNComment>();
			QuestionNComment QnC;
			
			while (rs.next()) {
				int c_seq = rs.getInt("c_seq");
				String c_commenter_name = rs.getString("c_commenter_name");
				String c_comment_content = rs.getString("c_comment_content");
				Date c_reg_date = rs.getDate("c_reg_date");
				String c_answer = rs.getString("c_answer");
				
				int q_seq = rs.getInt("q_seq");
				String q_title = rs.getString("q_title");
				String q_content = rs.getString("q_content");
				Date q_reg_date = rs.getDate("q_reg_date");
				String q_contact_number = rs.getString("q_contact_number");
				String q_email = rs.getString("q_email");
				String q_name = rs.getString("q_name");
				String q_password = rs.getString("q_password");
				String q_category = rs.getString("q_category");
				
				QnC = new QuestionNComment(c_seq, c_commenter_name, c_comment_content, c_reg_date, c_answer, q_seq, q_title, q_content, q_reg_date, q_contact_number, q_email, q_name, q_password, q_category);
				QnCs.add(QnC);
			}
			
			request.setAttribute("QnCs", QnCs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		
	}

//true false 가져와서 넣기
	public static void getAllQnCcheckbox(boolean completed, boolean uncompleted, HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT q.*, c.*");
		sqlBuilder.append(" FROM question_tbl q");
		sqlBuilder.append(" LEFT JOIN comment_tbl c");
		sqlBuilder.append(" ON q.q_seq = c.q_seq");
		if (completed == true || uncompleted == true) {
				if (completed == true && uncompleted == true) {
					
				}else if (completed == true) {
		            sqlBuilder.append(" WHERE c.c_answer = 1");
		        } else {
		            sqlBuilder.append(" WHERE c.c_answer IS NULL");
		        }
		}
		sqlBuilder.append(" ORDER BY q.q_reg_date");

		String sql = sqlBuilder.toString();
		
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			QnCs = new ArrayList<QuestionNComment>();
			QuestionNComment QnC;
			
			while (rs.next()) {
				int c_seq = rs.getInt("c_seq");
				String c_commenter_name = rs.getString("c_commenter_name");
				String c_comment_content = rs.getString("c_comment_content");
				Date c_reg_date = rs.getDate("c_reg_date");
				String c_answer = rs.getString("c_answer");
				
				int q_seq = rs.getInt("q_seq");
				String q_title = rs.getString("q_title");
				String q_content = rs.getString("q_content");
				Date q_reg_date = rs.getDate("q_reg_date");
				String q_contact_number = rs.getString("q_contact_number");
				String q_email = rs.getString("q_email");
				String q_name = rs.getString("q_name");
				String q_password = rs.getString("q_password");
				String q_category = rs.getString("q_category");
				
				QnC = new QuestionNComment(c_seq, c_commenter_name, c_comment_content, c_reg_date, c_answer, q_seq, q_title, q_content, q_reg_date, q_contact_number, q_email, q_name, q_password, q_category);
				QnCs.add(QnC);
			}
			
			request.setAttribute("QnCs", QnCs);
			System.out.println("QnCs: "+ QnCs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
		
	}
	
	public static void Qpaging(int page, HttpServletRequest request) {
		
		request.setAttribute("curPageNo", page);
		
		int cnt = 5; 
		int total = QnCs.size(); 
		int pageCount = (int)Math.ceil((double)total / cnt);
		request.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt * (page -1));
		
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<QuestionNComment> items = new ArrayList<QuestionNComment>();
		
		
		for (int i = start-1; i > end; i--) {
			items.add(QnCs.get(i));
		}
		
		request.setAttribute("QnCs", items);
		
	
	}
	
	public static void QpagingAdmin(int page, HttpServletRequest request) {
		
		
		int cnt = 8; 
		int total = QnCs.size(); 
		int pageCount = (int)Math.ceil((double)total / cnt);
		if(pageCount < page) {
			page = pageCount;
		}
		request.setAttribute("curPageNo", page);
		System.out.println("page: " + page);
		request.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt * (page -1));
		System.out.println("start ::: " + start );
		
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<QuestionNComment> items = new ArrayList<QuestionNComment>();
		
		
		for (int i = start-1; i > end; i--) {
			items.add(QnCs.get(i));
		}

			request.setAttribute("QnCs", items);
			System.out.println("items 내부 확인: "+ items);
	}
	
	
	// getAllQnCchecked 메소드 수정
	public static void getAllQnCchecked(boolean checkbox1, boolean checkbox2, HttpServletRequest request, HttpServletResponse response) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    StringBuilder sqlBuilder = new StringBuilder("SELECT q.*, c.* FROM question_tbl q LEFT JOIN comment_tbl c ON q.q_seq = c.q_seq");
	    
	    System.out.println();
	    if (checkbox1 || checkbox2) {
	        sqlBuilder.append(" WHERE");
	        if (checkbox1) {
	            sqlBuilder.append(" c.c_answer = 1");
	        }
	        if (checkbox2) {
	            if (checkbox1) {
	                sqlBuilder.append(" OR");
	            }
	            sqlBuilder.append(" c.c_answer IS NULL");
	        }
	    }

	    sqlBuilder.append(" ORDER BY q.q_reg_date");

	    try {
	        con = DBManagerhalo.connect();
	        pstmt = con.prepareStatement(sqlBuilder.toString());
	        rs = pstmt.executeQuery();  // executeQuery로 변경

	        QnCs = new ArrayList<QuestionNComment>();
	        QuestionNComment QnC;

	        while (rs.next()) {
	            int c_seq = rs.getInt("c_seq");
	            String c_commenter_name = rs.getString("c_commenter_name");
	            String c_comment_content = rs.getString("c_comment_content");
	            Date c_reg_date = rs.getDate("c_reg_date");
	            String c_answer = rs.getString("c_answer");

	            int q_seq = rs.getInt("q_seq");
	            String q_title = rs.getString("q_title");
	            String q_content = rs.getString("q_content");
	            Date q_reg_date = rs.getDate("q_reg_date");
	            String q_contact_number = rs.getString("q_contact_number");
	            String q_email = rs.getString("q_email");
	            String q_name = rs.getString("q_name");
	            String q_password = rs.getString("q_password");
	            String q_category = rs.getString("q_category");

	            QnC = new QuestionNComment(c_seq, c_commenter_name, c_comment_content, c_reg_date, c_answer, q_seq, q_title, q_content, q_reg_date, q_contact_number, q_email, q_name, q_password, q_category);
	            QnCs.add(QnC);
	        }

	        request.setAttribute("QnCs", QnCs);
	        System.out.println("체크박스 결과 확인:" + QnCs);

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManagerhalo.close(con, pstmt, rs);
	    }
	}
	
	
}
	




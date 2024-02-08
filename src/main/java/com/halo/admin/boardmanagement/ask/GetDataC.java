package com.halo.admin.boardmanagement.ask;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.user.qa.question.QuestionDAO;
@WebServlet("/GetDataC")
public class GetDataC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonData = QuestionDAO.questionList(request, response);
		QuestionDAO.questionList(request, response);
		QuestionDAO.getQuestionNComment(request);
		
		// request의 인코딩 확인
		String encoding = request.getCharacterEncoding();
		if (encoding != "UTF-8") {
		  request.setCharacterEncoding("UTF-8");
		}
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");

		
	    // 응답의 Content-Type 설정
	    response.setContentType("application/json");

	    // 생성한 JSON 데이터를 클라이언트로 전송
	    response.getWriter().write(jsonData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonData = QuestionDAO.questionList(request, response);
		QuestionDAO.questionList(request, response);
		
		// request의 인코딩 확인
		String encoding = request.getCharacterEncoding();
		if (encoding != "UTF-8") {
		  request.setCharacterEncoding("UTF-8");
		}
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");

		
	    // 응답의 Content-Type 설정
	    response.setContentType("application/json");

	    // 생성한 JSON 데이터를 클라이언트로 전송
	    response.getWriter().write(jsonData);

	}

}

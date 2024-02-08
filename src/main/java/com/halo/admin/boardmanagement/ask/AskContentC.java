package com.halo.admin.boardmanagement.ask;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.user.qa.question.QuestionDAO;

@WebServlet("/AskContentC")
public class AskContentC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		QuestionDAO.getAllQuestions(request);
//		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
//		request.setAttribute("resultList", resultList);
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");
		
		AskDAO.getAllQnC(request, response);
		AskDAO.QpagingAdmin(1, request);
		
		
		request.setAttribute("menu", "/admin/boardmanagement/ask/askContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		QuestionDAO.getAllQuestions(request);
		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
		request.setAttribute("resultList", resultList);
		
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");
		
		AskDAO.getAllQnC(request, response);
		AskDAO.QpagingAdmin(1, request);
		
		request.setAttribute("menu", "/admin/boardmanagement/ask/askContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

	
}

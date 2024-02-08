package com.halo.user.qa.question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.admin.boardmanagement.ask.AskDAO;
import com.halo.admin.boardmanagement.ask.QuestionNComment;

@WebServlet("/QuestionDeleteC")
public class QuestionDeleteC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDAO.deleteQuestionNComment(request);
//		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
//		request.setAttribute("resultList", resultList);
		AskDAO.getAllQnC(request, response);
		AskDAO.Qpaging(1, request);
		
		String subMenu = "qa/question/question";
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", subMenu + ".jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDAO.deleteQuestionNComment(request);
//		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
//		request.setAttribute("resultList", resultList);
		AskDAO.getAllQnC(request, response);
		AskDAO.Qpaging(1, request);
		
		String subMenu = "qa/question/question";
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", subMenu + ".jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

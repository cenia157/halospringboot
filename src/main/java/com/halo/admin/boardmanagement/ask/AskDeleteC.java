package com.halo.admin.boardmanagement.ask;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.user.qa.question.QuestionDAO;

@WebServlet("/AskDeleteC")
public class AskDeleteC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDAO.getAllQuestions(request);
		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
		request.setAttribute("resultList", resultList);
		QuestionDAO.deleteQuestionNComment(request);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제시도");
		QuestionDAO.getAllQuestions(request);
		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
		request.setAttribute("resultList", resultList);
		QuestionDAO.deleteQuestionNComment(request);
	}

}

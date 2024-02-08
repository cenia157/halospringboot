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
import com.halo.main.MainpageDAO;

@WebServlet("/QuestionDetailC")
public class QuestionDetailC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainpageDAO.getMdao().getAllHompage_common(request);
		// request의 인코딩 확인
		String encoding = request.getCharacterEncoding();
		if (encoding != "UTF-8") {
			request.setCharacterEncoding("UTF-8");
		}
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");

		QuestionDAO.getQuestionNComment(request);
		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
		request.setAttribute("resultList", resultList);
		
		// 현재 글의 ID를 파라미터로 받음
	    String questionId = request.getParameter("q_seq");

	    // 글 목록을 가져오고, 현재 글을 설정한 후 JSP로 포워딩
	    request.setAttribute("resultList", resultList);
	    request.setAttribute("questionId", questionId); // 현재 글의 ID를 속성에 추가

		String subMenu = "qa/question/questionDetail";
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", subMenu + ".jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainpageDAO.getMdao().getAllHompage_common(request);
		// request의 인코딩 확인
		String encoding = request.getCharacterEncoding();
		if (encoding != "UTF-8") {
			request.setCharacterEncoding("UTF-8");
		}
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");

		QuestionDAO.getQuestionNComment(request);
		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
		request.setAttribute("resultList", resultList);
		
	    // 현재 글의 ID를 파라미터로 받음
	    String questionId = request.getParameter("q_seq");

	    // 글 목록을 가져오고, 현재 글을 설정한 후 JSP로 포워딩
	    request.setAttribute("resultList", resultList);
	    request.setAttribute("questionId", questionId); // 현재 글의 ID를 속성에 추가
		
		String subMenu = "qa/question/questionDetail";
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", subMenu + ".jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}

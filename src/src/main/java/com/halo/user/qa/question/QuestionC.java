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

@WebServlet("/QuestionC")
public class QuestionC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request의 인코딩 확인
		String encoding = request.getCharacterEncoding();
		if (encoding != "UTF-8") {
			request.setCharacterEncoding("UTF-8");
		}
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");
		
		MainpageDAO.getMdao().getAllHompage_common(request);
		
		AskDAO.getAllQnC(request, response);
		AskDAO.Qpaging(1, request);
		
		String subMenu = "qa/question/question";
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", subMenu + ".jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request의 인코딩 확인
		String encoding = request.getCharacterEncoding();
		if (encoding != "UTF-8") {
			request.setCharacterEncoding("UTF-8");
		}
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");

		MainpageDAO.getMdao().getAllHompage_common(request);
		
		QuestionDAO.questionSubmit(request);
		AskDAO.getAllQnC(request, response);
		AskDAO.Qpaging(1, request);
		
		String subMenu = "qa/question/question";
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", subMenu + ".jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}

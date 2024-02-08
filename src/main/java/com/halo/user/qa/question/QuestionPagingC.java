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

@WebServlet("/QuestionPagingC")
public class QuestionPagingC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainpageDAO.getMdao().getAllHompage_common(request);
		
//		List<QuestionNComment> resultList = AskDAO.QuestionsAndComments();
//		request.setAttribute("resultList", resultList);
		int p = Integer.parseInt(request.getParameter("p"));
		System.out.println(p);

		AskDAO.getAllQnC(request, response);
		AskDAO.Qpaging(p, request);
		
		String subMenu = "qa/question/question";
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", subMenu + ".jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

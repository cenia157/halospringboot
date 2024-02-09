package com.halo.admin.boardmanagement.ask;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AskPagingC")
public class AskPagingC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AskDAO.getAllQnC(request, response);

		int p = Integer.parseInt(request.getParameter("p"));
		System.out.println("ASK paging: " + p);

		AskDAO.QpagingAdmin(p, request);
		
		request.setAttribute("menu", "/admin/boardmanagement/ask/askContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AskDAO.getAllQnC(request, response);

		int p = Integer.parseInt(request.getParameter("p"));
		System.out.println(p);

		AskDAO.QpagingAdmin(p, request);
		
		request.setAttribute("menu", "/admin/boardmanagement/ask/askContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

}

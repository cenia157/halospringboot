package com.halo.admin.boardmanagement.frequenthyask;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FAQPagingC")
public class FAQPagingC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FAQDAO.getAllFAQ(request);
		
		int p = Integer.parseInt(request.getParameter("p"));
		System.out.println(p);
		
		FAQDAO.FAQpagingAdmin(p, request);
		
		request.setAttribute("menu", "/admin/boardmanagement/frequenthyask/frequenthyaskContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

package com.halo.user.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.halo.main.MainpageDAO;

@WebServlet("/CompletC")
public class CompletC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("serviceStep", "complet.jsp");
		request.setAttribute("step6Pos", "#ffdf6c");
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", "service/serviceApply/serviceApply.jsp");
		MainpageDAO.getMdao().getAllHompage_common(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
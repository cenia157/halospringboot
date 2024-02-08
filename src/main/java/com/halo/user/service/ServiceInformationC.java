package com.halo.user.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.main.MainpageDAO;

/**
 * Servlet implementation class ServiceInformationC
 */
@WebServlet("/ServiceInformationC")
public class ServiceInformationC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", "service/serviceInformation/serviceInformation.jsp");
		MainpageDAO.getMdao().getAllHompage_common(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

package com.halo.admin.manager.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.admin.calender.company.CompanyDAO;

@WebServlet("/StaffRegC")
public class StaffRegC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StaffDAO.staffReg(request);
		response.sendRedirect("StaffC");
//		request.setAttribute("menu", "/admin/manager/staff/staffContent.jsp");
//		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	
	}

}

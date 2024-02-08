package com.halo.admin.customerCare.customerInfoMgmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.admin.calender.reservation.ReservationDAO;

@WebServlet("/CustomerInfoMgmtC")
public class CustomerInfoMgmtC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (request.getSession().getAttribute("login_session") == null) {
//			response.sendRedirect("LoginPageC");
//		} else {
		request.setAttribute("menuname", "顧客情報の管理");
		request.setAttribute("menu", "/admin/customerCare/customerInfoMgmt/customerInfoMgmt.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
//	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

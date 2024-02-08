package com.halo.admin.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginC")
public class LoginC extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO.login(request);
		
		AdminDTO account = (AdminDTO) request.getSession().getAttribute("login_session");
		System.out.println(account);
		if (request.getAttribute("result").equals("成功")) {
			response.sendRedirect("AdminC");
		}else {
			request.getRequestDispatcher("LoginPageC").forward(request, response);
		}
	}

}

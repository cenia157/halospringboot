package com.halo.user.information.company;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.main.MainpageDAO;

@WebServlet("/InfoCompanyC")
public class InfoCompanyC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainpageDAO.getMdao().getAllHompage_common(request);
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu","information/company/inform.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

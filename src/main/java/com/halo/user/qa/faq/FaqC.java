package com.halo.user.qa.faq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.admin.boardmanagement.frequenthyask.FAQDAO;
import com.halo.main.MainpageDAO;

@WebServlet("/FaqC")
public class FaqC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainpageDAO.getMdao().getAllHompage_common(request);
		FAQDAO.getAllFAQ(request);
		FAQDAO.getFAQDetail(request, response);
		
		
		String subMenu = "qa/faq/faq";
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", subMenu + ".jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

package com.halo.user.introduce.announcement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.main.MainpageDAO;

@WebServlet("/Announced_paging_C")
public class Announced_paging_C extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnouncedDAO.getAllAnnouncements(request);
		int p = Integer.parseInt(request.getParameter("p"));
		AnnouncedDAO.paging(p, request);
		MainpageDAO.getMdao().getAllHompage_common(request);
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", "/user/introduce/announcement/announcement_contentPage.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}

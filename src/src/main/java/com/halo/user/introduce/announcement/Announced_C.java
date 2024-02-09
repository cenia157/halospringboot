package com.halo.user.introduce.announcement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.main.MainpageDAO;

@WebServlet("/Announced_C")
public class Announced_C extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnouncedDAO.getAllAnnouncements(request);
		AnnouncedDAO.paging(1, request);
		MainpageDAO.getMdao().getAllHompage_common(request);
		request.setAttribute("menu", "user/menu-index.jsp");
		request.setAttribute("subMenu", "/user/introduce/announcement/announcement_contentPage.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1건의 모달 상세 조회 후, DTO세팅까지.
		AnnouncedDAO.getAnnouncement(request);
		String writer = (String) request.getAttribute("writer");
		String title = (String) request.getAttribute("title");
		String content = (String) request.getAttribute("content");
		String dateStr = (String) request.getAttribute("dateStr");
		
		response.setContentType("text/plain; charset=UTF-8");
		String str = writer + "|"  +title + "|"+ content + "|" + dateStr;
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
	}

}

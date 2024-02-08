package com.halo.admin.boardmanagement.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NoticePagingC")
public class NoticePagingC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice.getAllNotice(request, response);
		int p = 1;
		if(!request.getParameter("p").equals("")) {
			p = Integer.parseInt(request.getParameter("p"));
		}

		Notice.noticePaging(p, request);
		 
		request.setAttribute("menuname", "お知らせ");
		request.setAttribute("seq", request.getParameter("seq"));
		request.setAttribute("pageNum", p);
		request.setAttribute("menu", "/admin/boardmanagement/notice/noticeContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice.getAllNotice(request, response);

		int p = Integer.parseInt(request.getParameter("p"));
		System.out.println(p);

		Notice.noticePaging(p, request);
		
		
		request.setAttribute("menu", "/admin/boardmanagement/notice/noticeContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

}

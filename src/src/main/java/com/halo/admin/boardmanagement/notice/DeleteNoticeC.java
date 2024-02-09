package com.halo.admin.boardmanagement.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteNoticeC")
public class DeleteNoticeC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Notice.deleteNotice(request);
			response.sendRedirect("NoticePagingC?p="+request.getParameter("p")+"&checkVal="+request.getParameter("checkVal"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}

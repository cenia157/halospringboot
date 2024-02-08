package com.halo.admin.boardmanagement.ask;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/CheckboxPagingC")
public class CheckboxPagingC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request의 인코딩 확인
		String encoding = request.getCharacterEncoding();
		if (encoding != "UTF-8") {
			request.setCharacterEncoding("UTF-8");
		}
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");

		int p = Integer.parseInt(request.getParameter("p"));
		System.out.println("paging 결과: "+ p);
		
		AskDAO.QpagingAdmin(p, request);
		// QnCs를 JSON으로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonQnCs = objectMapper.writeValueAsString(request.getAttribute("QnCs"));
		
		response.getWriter().write(jsonQnCs);
		
		request.setAttribute("menu", "/admin/boardmanagement/ask/askContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

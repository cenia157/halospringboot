package com.halo.admin.boardmanagement.frequenthyask;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getFAQDetailC")
public class getFAQDetailC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsonData = FAQDAO.FAQList(request, response);
		FAQDAO.getFAQDetail(request, response);
		FAQDAO.FAQList(request, response);

		// 이거 iso-8859-1로 저장된 값을 utf-8로 불러오는 코드다. 지우면 ?????가 나온다
		response.setCharacterEncoding("UTF-8");

		response.setContentType("application/json");
		response.getWriter().write(jsonData);
	}
}

package com.halo.admin.boardmanagement.ask;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCommentsC")
public class GetCommentsC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request의 인코딩 확인
		String encoding = request.getCharacterEncoding();
		if (encoding != "UTF-8") {
		  request.setCharacterEncoding("UTF-8");
		}
		// UTF-8로 설정
		response.setCharacterEncoding("utf-8");


		try {
			
	        String jsonData = AskDAO.commentList(request, response);
	        response.setContentType("application/json");
	        response.getWriter().write(jsonData);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    }
	}

}

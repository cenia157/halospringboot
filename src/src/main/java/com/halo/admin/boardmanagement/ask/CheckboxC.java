package com.halo.admin.boardmanagement.ask;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/CheckboxC")
public class CheckboxC extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean completed = Boolean.parseBoolean(request.getParameter("completed"));
		boolean uncompleted = Boolean.parseBoolean(request.getParameter("uncompleted"));
		AskDAO.getAllQnCcheckbox(completed, uncompleted, request, response);
		// QnCs를 JSON으로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonQnCs = objectMapper.writeValueAsString(request.getAttribute("QnCs"));
		
		response.getWriter().write(jsonQnCs);

	}

}

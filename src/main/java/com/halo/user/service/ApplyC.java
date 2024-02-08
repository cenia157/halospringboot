package com.halo.user.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.halo.main.MainpageDAO;

@WebServlet("/ApplyC")
public class ApplyC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// 문자인코딩형식
	request.setCharacterEncoding("UTF-8");
	SeviceApplyDAO.apply(request);
//	MainpageDAO.getMdao().getAllHompage_common(request);
	response.sendRedirect("ApplyRedirectC");
	
	
	}

}
package com.halo.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainBannerUpdateC")
public class MainBannerUpdateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("menuname", "クイックメニュー設定");
		
		//지금컨트롤러, 결과 파라미터
		MainpageDAO.getMdao().getAllHompage_common(request);
		//Admin page 메뉴(index.jsp) 안고가기 
		request.setAttribute("menu", "/admin/homepageSetting/mainpage/mainpageContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainpageDAO.getMdao().updateMainBanner(request, response);
		response.sendRedirect("MainBannerUpdateC");
	}

}

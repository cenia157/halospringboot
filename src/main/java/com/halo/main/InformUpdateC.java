package com.halo.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.utils.HaloUtils;

@WebServlet("/InformUpdateC")
public class InformUpdateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("menuname", "会社情報変更");
		//getAll로 DTO깐거 가져옴
		MainpageDAO.getMdao().getAllHompage_common(request);
		//AdminC에 있던 menu 어트리뷰트(경로) 정의
		//Admin page 메뉴(index.jsp) 안고가기 => 디스페쳐
		request.setAttribute("menu", "/admin/homepageSetting/information/informationContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업뎃 작업 메소드
		MainpageDAO.getMdao().updateFooter(request);
		response.sendRedirect("InformUpdateC?" +  HaloUtils.setParam(request));
	}

}

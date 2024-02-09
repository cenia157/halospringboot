package com.halo.admin.popup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.main.MainpageDAO;

@WebServlet("/PopupC")
public class PopupC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("menuname", "ポップアップ設定");
		//지금컨트롤러, 결과 파라미터
		MainpageDAO.getMdao().getAllHompage_common(request);
		MainpageDAO.getMdao().getPopupInfoForAdmin(request);
		//Admin page 메뉴(index.jsp) 안고가기 => 디스페쳐
		request.setAttribute("menu", "/admin/popup/popupContent.jsp");
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainpageDAO.getMdao().popupSet(request,response);
		System.out.println("popupSet지나감");
	}

}

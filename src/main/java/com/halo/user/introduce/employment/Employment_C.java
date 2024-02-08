package com.halo.user.introduce.employment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.main.MainpageDAO;

@WebServlet("/Employment_C")
public class Employment_C extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MainpageDAO.getMdao().getAllHompage_common(request);
        request.setAttribute("menu", "user/menu-index.jsp");
        request.setAttribute("subMenu", "/user/introduce/employment/employment_contentPage.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}

package com.halo.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitorC")
public class VisitorC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setContentType("text/html;charset=UTF-8");

	        // URL �Ķ���Ϳ��� �� ��������
	        String koreanTime = request.getParameter("koreanTime");

	        // ���� ���� �ֿܼ� ���
	        System.out.println("�������� ���� ��: " + koreanTime);

	        // ���� ���� �������� Ŭ���̾�Ʈ���� ������
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head><title>Received Time</title></head>");
	        out.println("<body>");
	        out.println("<h1>�������� ���� �ð�:</h1>");
	        out.println("<p>" + koreanTime + "</p>");
	        out.println("</body>");
	        out.println("</html>");
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // URL �Ű��������� visitCount �� visitTime ����
        String visitCount = request.getParameter("visitCount");
        String visitTime = request.getParameter("visitTime");
        String qqq = request.getParameter("qqq");

        // �ʿ��� ��� ���� ����
        System.out.println("11111111111");
        System.out.println(visitCount);
        System.out.println("22222222222");
        System.out.println(visitTime);
        System.out.println("33333333333");
        System.out.println(qqq);
        System.out.println("--------------------");
	
	}

}

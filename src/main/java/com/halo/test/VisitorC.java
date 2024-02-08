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

	        // URL 파라미터에서 값 가져오기
	        String koreanTime = request.getParameter("koreanTime");

	        // 받은 값을 콘솔에 출력
	        System.out.println("서블릿에서 받은 값: " + koreanTime);

	        // 받은 값을 응답으로 클라이언트에게 보내기
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head><title>Received Time</title></head>");
	        out.println("<body>");
	        out.println("<h1>서블릿에서 받은 시간:</h1>");
	        out.println("<p>" + koreanTime + "</p>");
	        out.println("</body>");
	        out.println("</html>");
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // URL 매개변수에서 visitCount 및 visitTime 추출
        String visitCount = request.getParameter("visitCount");
        String visitTime = request.getParameter("visitTime");
        String qqq = request.getParameter("qqq");

        // 필요한 경우 응답 전송
        System.out.println("11111111111");
        System.out.println(visitCount);
        System.out.println("22222222222");
        System.out.println(visitTime);
        System.out.println("33333333333");
        System.out.println(qqq);
        System.out.println("--------------------");
	
	}

}

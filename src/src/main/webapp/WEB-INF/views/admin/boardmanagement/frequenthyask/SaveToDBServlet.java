package com.halo.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveToDBServlet")







public class SaveToDBServlet extends HttpServlet {

	
	
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("editor");

		try {
			// ����Ŭ DB ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##kjw9600",
					"kjw9600");

			// CKEditor���� �Էµ� ������ DB�� �����ϴ� SQL ���� ����
			String sql = "INSERT INTO test (content_column_name) VALUES (?);";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.executeUpdate();

			System.out.println("Data saved to the database successfully!");

			// ���ҽ� ����
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
	}
}

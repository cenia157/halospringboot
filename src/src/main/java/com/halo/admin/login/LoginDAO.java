package com.halo.admin.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.halo.main.DBManagerhalo;

public class LoginDAO {
	private static Connection con = null;

	public static void loginCheck(HttpServletRequest request) throws IOException {
		LoginDAO account = (LoginDAO) request.getSession().getAttribute("login_session");

		
	} // loginCheck()

	public static void login(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			request.setCharacterEncoding("UTF-8");
			String sql = "select * from admin_acount where a_id= ? ";

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
//			System.out.println("---------------------");
//			System.out.println("파라미터 Id ::: " + id);
//			System.out.println("파라미터 pw ::: " + pw);

			String dbPW = "";
			String result = "";

			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbPW = rs.getString("a_pw");
				System.out.println("dwPW ::: + " + dbPW);

				if (pw.equals(dbPW)) {
					result = "成功";
					System.out.println("result ::: " + result);
					AdminDTO adminDTO = new AdminDTO();
					adminDTO.setA_id(id);
					adminDTO.setA_pw(dbPW);
					adminDTO.setA_name(rs.getString("a_name"));

					HttpSession hs = request.getSession();
					int timer = 7200;
					hs.setMaxInactiveInterval(timer);
					System.out.println(hs.getMaxInactiveInterval());
					hs.setAttribute("sessionTimeout", timer);
					hs.setAttribute("login_session", adminDTO);
					hs.setAttribute("login_name", rs.getString("a_name"));
				} else {
					result = "パスワードエラー！";
					System.out.println("result ::: " + result);
					System.out.println();
				} // inner if-else

			} else {
				result = "存在しないアカウント(ログイン失敗)";
				System.out.println("result ::: " + result);
			} // if-else
			request.setAttribute("result", result);
		} catch (Exception e) {
			System.out.println("Account_DAO의 login() 오류 발생");
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
		}
	}

	public static void logout(HttpServletRequest request) {
		// 로그아웃 하는일

		// 애초에 만들어진적이 없거나, 설정 시간 만료
		// 세션 죽으면
		HttpSession hs = request.getSession();
		hs.setAttribute("login_session", null);
		System.out.println("--------------");
		System.out.println("세션종료 실행");
//		hs.removeAttribute("account");
//		hs.invalidate(); // 비 권장 
	} // logout()

	public static void extendTime(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 시간연장
			HttpSession session = request.getSession();
			// 세션에서 속성 가져오기
			Object sessionTimeoutObj = request.getSession().getAttribute("sessionTimeout");
			System.out.println("sessionTimeoutObj" + sessionTimeoutObj);

			// int로 변환할 변수 초기화
			int sessionTimeout = 0; // 기본값을 설정하거나 에러 상황에 대한 대체 값으로 변경 가능

			sessionTimeout = Integer.parseInt(sessionTimeoutObj.toString());
			// 세션 연장 코드
			System.out.println("sessionTimeout : " + sessionTimeout);
			session.setMaxInactiveInterval(sessionTimeout);
			System.out.println(session.getMaxInactiveInterval());
			// 클라이언트에게 응답
			response.setContentType("text/plain");
			response.getWriter().write("Session extended");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

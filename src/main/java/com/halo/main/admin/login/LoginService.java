package com.halo.main.admin.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {

	@Autowired
	LoginMapper loginmappser;
	
	public String login(Model model, @RequestParam String a_id, @RequestParam String a_pw, HttpServletRequest request) {
		
			AdminAccount adminAccount = loginmappser.login(a_id);
			
			String result = "";

			if (adminAccount != null) {
				System.out.println("dwPW ::: + " + adminAccount.getA_pw());

				if (a_pw.equals(adminAccount.getA_pw())) {
					result = "成功";
					System.out.println("result ::: " + result);

					HttpSession hs = request.getSession();
//					int timer = 7200;
					int timer = 5;
					hs.setMaxInactiveInterval(timer);
					System.out.println(hs.getMaxInactiveInterval());
					hs.setAttribute("sessionTimeout", timer);
					hs.setAttribute("login_session", adminAccount );
					hs.setAttribute("login_name", adminAccount.getA_name());
				} else {
					result = "パスワードエラー！";
					System.out.println("result ::: " + result);
				} // inner if-else

			} else {
				result = "存在しないアカウント(ログイン失敗)";
				System.out.println("result ::: " + result);
			} // if-else
			model.addAttribute("result", result);
			if (result.equals("成功")) {
				return"redirect:/admin/dashboard";
			}else {
				return "/admin/login/login";
			}
		}

	public String loginCheck(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		
		if (hs.getAttribute("login_session") == null) {
			return "Login_required";
		} else {
			return "ok";
		}
	}
	
	public void logout(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		hs.setAttribute("login_session", null);
	}

	public String loginExtendTime(HttpServletRequest request) {
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

		return "LoginExtendTime";
	} 

	
	
}

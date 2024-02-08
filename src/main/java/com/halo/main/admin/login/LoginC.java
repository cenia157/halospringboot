package com.halo.main.admin.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginC {
	@GetMapping("/login")
	public String login(Model model) {
		
		// 메뉴 상단 이름 표시
		model.addAttribute("menuname", "ダッシュボード");
		// 메뉴 인클루드 셋어트리뷰트
		// perix에 /WEB-INF/views/를 걸어두었는데 어드민 페이지에서 인클루드를 하면 /WEB-INF/views/가 필요합니다.
		// 이유는 WEB-INF의 보안정책으로 인한 접근 불가때문인거같음
		model.addAttribute("menu", "/WEB-INF/views/admin/dashboard/dashboard.jsp");
		
		// void값에 따른 
		return "/admin/index";
	}
}

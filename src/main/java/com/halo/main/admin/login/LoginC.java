package com.halo.main.admin.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/admin")
@Controller
public class LoginC {
	
	@Autowired
	private LoginService service;
	
	@GetMapping("/loginPage")
	public String loginPage(Model model) {
		
		return "/admin/login/login";
	}
	@PostMapping("/login")
	public String login(Model model, @RequestParam("a_id") String a_id, @RequestParam("a_pw") String a_pw, HttpServletRequest request) {
		System.out.println(service.login(model, a_id, a_pw, request));
		return service.login(model, a_id, a_pw, request);
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		service.logout(request);
		return "redirect:loginPage";
	}
	
	@ResponseBody
	@GetMapping("/loginExtendTime")
	public String loginExtendTime(HttpServletRequest request) {
		
		return service.loginExtendTime(request);
	}
	
}

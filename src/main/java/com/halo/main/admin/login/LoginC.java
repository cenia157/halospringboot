package com.halo.main.admin.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginC {
	@GetMapping("/login")
	public String login() {
		
		return "/admin/index";
	}
	
}

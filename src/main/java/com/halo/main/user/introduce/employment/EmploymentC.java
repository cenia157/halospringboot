package com.halo.main.user.introduce.employment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class EmploymentC {
	@GetMapping("/employment")
	public String employment(Model model) {
		
//		MainpageDAO.getMdao().getAllHompage_common(request);
		model.addAttribute("menu", "/WEB-INF/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/WEB-INF/views/user/introduce/employment/employment_contentPage.jsp");
		return "index";
		
	}

}

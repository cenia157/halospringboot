package com.halo.main.user.introduce.album;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumC {
	@GetMapping("AlbumC")
	public String AlbumC(Model model) {
		
		
//		MainpageDAO.getMdao().getAllHompage_common(request);
		model.addAttribute("menu", "/WEB-INF/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/WEB-INF/views/user/introduce/employment/employment_contentPage.jsp");
		
		return "index";
	}

}

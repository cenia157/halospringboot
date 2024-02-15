package com.halo.main.admin.userpage_update.logo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/homepage-update")
public class LogoC {
	
	@Autowired
	private LogoDAO logoDao;
	
	@GetMapping("/logo")
	public String goLogo(Model model) {
		
		model.addAttribute("menuname","ロゴ変更");
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/logo/logoContent.jsp");
		//기존 이미지(DB)어트리뷰트 세팅
//		model.addAttribute("hdto", logoDao.getLogoDTO());
		return "/admin/index";
	}
	
	@PostMapping("/logo/upload-file")
	public String uploadLogoFile() {
		//비동기(업뎃예정 img 미리보기)
		
		return "test";
	}
	
	@PostMapping("/logo/update")
	public String updateLogo() {
		//업데이트(실제 DB에 업뎃)
		return "redirect:/admin/homepage-update/logo";
	}
	
}

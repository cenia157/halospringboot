package com.halo.main.admin.userpage_update.quick_menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/homepage-update")
public class QuickMenuC {
	
	@Autowired
	private QuickMenuDAO qmDao;
	
	@GetMapping("/quick-menu")
	public String getQuickMenu(Model model) {
		
		model.addAttribute("menuname","クイックメニュー設定");
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/mainpage/mainpageContent.jsp");
		//돌릴거 세팅
//		System.out.println(qmDao.getListQuickMenu());
		model.addAttribute("topBanners", qmDao.getListQuickMenu());
		return "/admin/index";
	}
	
	@ResponseBody
	@PostMapping("/quick-menu/update")
	public String updateQuickMenu(@RequestParam("m_name4") String m_name4,
			@RequestParam("m_name5") String m_name5,
			@RequestParam("m_name6") String m_name6,
			 Model model) {
		
		System.out.println("선택된value3개 : "+ m_name4 +", "+ m_name5 +", "+ m_name6);
		
		//업뎃하는일
		qmDao.updateQuickMenu(m_name4, m_name5, m_name6, model);
		
		return "redirect:/admin/homepage-update/quick-menu";
	}
	
	
	
}

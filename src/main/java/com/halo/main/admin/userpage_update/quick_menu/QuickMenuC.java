package com.halo.main.admin.userpage_update.quick_menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.halo.main.admin.userpage_update.information.AdminInformationDAO;

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
		model.addAttribute("topBanners", qmDao.getListQuickMenu());
		return "/admin/index";
	}
	
	//@ResponseBody 몸체를 주는거기 때문에 리다이렉트엔 못씀(자꾸따라가게됨)
	@PostMapping("/quick-menu/update")
	public String updateQuickMenu(@RequestParam("m_name4") String m_name4,
			@RequestParam("m_name5") String m_name5,
			@RequestParam("m_name6") String m_name6,
			 Model model) {
		
		//업뎃
		qmDao.updateQuickMenu(m_name4, m_name5, m_name6, model);
		
		return "redirect:/admin/homepage-update/quick-menu";
	}
	
	
	
}

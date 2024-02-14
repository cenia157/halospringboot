package com.halo.main.admin.userpage_update.information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halo.main.user.common.HomepageCommonDTO;


@Controller
@RequestMapping("/admin/homepage-update")
public class AdminInformationC {
	
	@Autowired
	private AdminInformationDAO aInfoDao;
	
	@GetMapping("/company-info")
	public String goInfo(Model model) {
		
		model.addAttribute("menuname", "会社情報変更");
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/information/informationContent.jsp");
		model.addAttribute("hdto",aInfoDao.getListInfo());
		return "/admin/index";
	}
	
	
//	@ResponseBody
	@PostMapping("/company-info/update")
	public String updateInfo(HomepageCommonDTO hdto) {
		//업뎃 하는 일
//		System.out.println("객체 : "+ hdto);
		aInfoDao.updateInfo(hdto);
		
		return "redirect:/admin/homepage-update/company-info";
	}
	
	
	
}

package com.halo.main.user.information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halo.main.admin.userpage_update.information.AdminInformationDAO;
import com.halo.main.user.common.HomepageDAO;
@RequestMapping("/introduce")
@Controller
public class InformationC {
	
	@Autowired
	private AdminInformationDAO aInfoDao;
	
	@Autowired
	private HomepageDAO homeDao;
	
	@GetMapping("/company")
	private String infoCompany(Model model) {
		
		model.addAttribute("menu","/views/user/menu-index.jsp");
		model.addAttribute("hdto", homeDao.getAllhomepage());
		model.addAttribute("subMenu","/views/user/information/company/inform.jsp");
		
		return "index";
		
	}
	
	@GetMapping("/map")
	private String infoMap(Model model) {
		
		model.addAttribute("menu","/views/user/menu-index.jsp");
		model.addAttribute("hdto", homeDao.getAllhomepage());
		model.addAttribute("subMenu","/views/user/information/map/map.jsp");
		return "index";
		
	}
	
	
}

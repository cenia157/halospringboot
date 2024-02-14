package com.halo.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.halo.main.admin.userpage_update.information.AdminInformationDAO;


@Controller
public class HC {
	
	@Autowired
	private AdminInformationDAO aInfoDao;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("menu", "home.jsp");
		model.addAttribute("hdto",aInfoDao.getListInfo());
		return "index";
	}
	
}

package com.halo.main.user.introduce.employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halo.main.user.common.HomepageDAO;

@Controller
@RequestMapping("/info")
public class EmploymentC {
	
    @Autowired
    private HomepageDAO homeDao; 
	
	@GetMapping("/employment")
	public String employment(Model model) {
		
//		MainpageDAO.getMdao().getAllHompage_common(request);
		model.addAttribute("menu", "/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/views/user/introduce/employment/employment_contentPage.jsp");
		model.addAttribute("hdto", homeDao.getAllhomepage());
		return "index";
		
	}

}

package com.halo.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.halo.main.admin.userpage_update.information.AdminInformationDAO;
import com.halo.main.admin.userpage_update.popup.PopupDAO;
import com.halo.main.user.common.HomepageDAO;
import com.halo.main.user.introduce.announcement.AnnouncedService;


@Controller
public class HC {
	//header,footer,(top&bottom)banner 정보 뿌리기
	@Autowired
	private HomepageDAO homeDao;
	//popup 
	@Autowired
	private PopupDAO popupDao;
	@Autowired
	private AnnouncedService aService;
	
	@GetMapping("/")
	public String home(Model model) {
		// 오단영 추가 
		model.addAttribute("announcements", aService.getMainPageAnnouncements());
		model.addAttribute("menu", "home.jsp");
		model.addAttribute("hdto",homeDao.getAllhomepage());
		model.addAttribute("pdto", popupDao.getPopupDTO());
		return "index";
	}
	
}

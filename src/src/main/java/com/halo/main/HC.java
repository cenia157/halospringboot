package com.halo.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.halo.user.introduce.announcement.AnnouncedDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HC {

	@GetMapping("/")
	public String home(HttpServletRequest request) {
//		MainpageDAO.getMdao().getAllHompage_common(request);
//
//		AnnouncedDAO.getMainAnnouncements(request);
//
//		MainpageDAO.getMdao().getPopupInfoForHC(request);
		request.setAttribute("menu", "home.jsp");
		return "index";
	}
}
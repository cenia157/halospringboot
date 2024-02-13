package com.halo.main.user.introduce.announcement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnouncedC {

	@Autowired
	private AnnouncedService aService;

	// 전체 조회 및 페이징 처리
	@GetMapping("/AnnouncedC")
	public String getAllAnnouncements(Model model) {

		model.addAttribute("announcements", aService.getAllAnnouncements());

		aService.announcedPaging(1, model);
//		MainpageDAO.getMdao().getAllHompage_common(request);
		model.addAttribute("menu", "/WEB-INF/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/WEB-INF/views/user/introduce/announcement/announcement_contentPage.jsp");

		return "index";
	}

//    // 클라이언트가 타이틀을 클릭할 때 POST 요청으로 오는 부분
//    @PostMapping("/AnnouncedC")
//    public void getAnnouncement(@RequestParam("an_seq") int anSeq, Model model) {
////        AnnouncedDTO announcement = announcedService.getAnnouncement(anSeq);
////        model.addAttribute("announcement", announcement);
//    	
//    	
//        
//        
//    }

	@ResponseBody
	@PostMapping("/AnnouncedC")
	public ResponseEntity<?> getAnnouncement(@RequestParam("an_seq") int anSeq) {
		AnnouncedDTO announcement = aService.getAnnouncement(anSeq);
		if (announcement != null) {
			return ResponseEntity.ok(announcement);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("공지사항을 찾을 수 없습니다.");
		}
	}



	// 페이징 처리
	@GetMapping("/AnnouncedPagingC")
	public String AnnouncedPagingC(@RequestParam(value = "p", required = false, defaultValue = "1") int p,
			Model model) {

		model.addAttribute("announcements", aService.getAllAnnouncements());

		aService.announcedPaging(p, model);
//		MainpageDAO.getMdao().getAllHompage_common(request);
		model.addAttribute("menu", "/WEB-INF/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/WEB-INF/views/user/introduce/announcement/announcement_contentPage.jsp");

		return "index";
	}
}

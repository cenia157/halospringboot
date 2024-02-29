package com.halo.main.user.introduce.announcement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.halo.main.user.common.HomepageDAO;

@RequestMapping("/info")
@Controller
public class AnnouncedC {

	@Autowired
	private AnnouncedService aService;
	
    @Autowired
    private HomepageDAO homeDao; 
    
	// 전체 조회 및 페이징 처리
	@GetMapping("/notice")
	public String getAllAnnouncements(Model model) {

		model.addAttribute("announcements", aService.getAllAnnouncements());

		aService.announcedPaging(1, model);
		model.addAttribute("menu", "/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/views/user/introduce/announcement/announcement_contentPage.jsp");
		model.addAttribute("hdto", homeDao.getAllhomepage());
		

		return "index";
	}

	// 모달창 조회
	@ResponseBody
	@PostMapping("/notice/getNotice")
	public ResponseEntity<?> getAnnouncement(@RequestParam("an_seq") int anSeq) {
		AnnouncedDTO announcement = aService.getAnnouncement(anSeq);
		if (announcement != null) {
			return ResponseEntity.ok(announcement);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("공지사항을 찾을 수 없습니다.");
		}
	}

	// 페이징처리
	@GetMapping("/notice/{p}")
	public String announcedPaging(@PathVariable(value = "p") int p, Model model) {
			
		model.addAttribute("announcements", aService.getAllAnnouncements());

		aService.announcedPaging(p, model);
//		MainpageDAO.getMdao().getAllHompage_common(request);
		model.addAttribute("menu", "/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/views/user/introduce/announcement/announcement_contentPage.jsp");
		model.addAttribute("hdto", homeDao.getAllhomepage());

		return "index";
	}
	
	
}

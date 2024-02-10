package com.halo.main.admin.boardmanagement.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticeC {

	@Autowired
	private NoticeService nService;
	
	@GetMapping("/NoticeMainC")
	public String getAllNotice(@RequestParam("checkVal") String checkVal, Model model) {
		
		model.addAttribute("notices", nService.getAllNotice(checkVal, model));
		
		nService.noticePaging(1,model);
		
		model.addAttribute("menuname", "お知らせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/notice/noticeContent.jsp");
		
		return "/admin/index";
	}
	
	@GetMapping("/NoticePagingC")
	public String GetNoticePagingC(@RequestParam(value = "p", required = false, defaultValue = "1") int p, @RequestParam("checkVal") String checkVal,@RequestParam(value = "seq", required = false) Integer seq, Model model) {
		
		model.addAttribute("notices", nService.getAllNotice(checkVal, model));
		nService.noticePaging(p,model);
		
		model.addAttribute("menuname", "お知らせ");
		System.out.println("seq확인 :: " + seq);
		if (seq != null) {
	        System.out.println("seq확인 :: " + seq);
	        model.addAttribute("seq", seq);
	    }
		model.addAttribute("pageNum", p);
		model.addAttribute("menuname", "お知らせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/notice/noticeContent.jsp");
		
		return "/admin/index";	
	}
	
	@PostMapping("/NoticePagingC")
	public String PostNoticePagingC(@RequestParam(value = "p", required = false, defaultValue = "1") int p, Model model) {
		
		nService.noticePaging(p,model);
		
		model.addAttribute("menuname", "お知らせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/notice/noticeContent.jsp");
		
		return "/admin/index";	
	}
	
	

}






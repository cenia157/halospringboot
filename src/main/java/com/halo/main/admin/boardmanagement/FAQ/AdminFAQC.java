package com.halo.main.admin.boardmanagement.FAQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class AdminFAQC {

	@Autowired
	private FAQAdminService faqadminservice;
	
	@GetMapping("/admin/faq")
	public String AdminFAQMain(Model model) {
		
		model.addAttribute("FAQs", faqadminservice.getAllFAQsAdmin());
		
		model.addAttribute("menuname", "よくある質問");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/frequenthyask_Test_JW/frequenthyaskContent.jsp");

		return "/admin/index";
	}
	
	@ResponseBody
	@GetMapping("/getFAQDetail")
	public String getFAQDetail(@RequestParam("qa_seq") int qa_seq, Model model) {
		
		model.addAttribute("FAQ", faqadminservice.getFAQDetail(qa_seq));
		
		model.addAttribute("menuname", "よくある質問");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/frequenthyask_Test_JW/frequenthyaskContent.jsp");

		return "/admin/index";
	}
	
	
	
}

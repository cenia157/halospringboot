package com.halo.main.user.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@ResponseBody("/qna")

@Controller
public class FAQC {

	@Autowired
	FAQService faqService;
	
	@GetMapping("/qna/faq")
	public String FAQMain(Model model) {
		
		model.addAttribute("FAQs", faqService.getAllFAQ());
		
		model.addAttribute("menu", "/WEB-INF/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/WEB-INF/views/user/qa/faq/faq.jsp");

		return "index";
	}
	
	@ResponseBody
	@PostMapping("/faqData")
	public String FAQDetail(@RequestParam int qa_seq) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("qa_seq: " + qa_seq);
		return faqService.getFAQDetail(qa_seq);
	}
	
	
}

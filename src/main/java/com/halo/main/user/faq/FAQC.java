package com.halo.main.user.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@ResponseBody
//	@GetMapping("/faqData")
//	public String getFAQData(@RequestParam("qa_seq") int qa_seq, Model model) {
//		System.out.println(faqService.getFAQDetail(qa_seq));
//		return faqService.getFAQDetail(qa_seq);
//	}



	
	
}

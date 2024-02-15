package com.halo.main.admin.boardmanagement.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin/boardManagement")
@Controller
public class AdminQuestionC {

	@Autowired
	private QuestionAdminService questionadminservice;
	
	@GetMapping("/question/{p}/{checkVal}")
	public String AdminQuestionMainPaging(
			@PathVariable(value = "p") int p
			, @PathVariable(value = "checkVal") String checkVal
			, Model model) {
		
		
		model.addAttribute("QnCs", questionadminservice.getAllQnCs(checkVal));
		questionadminservice.qaPaging(p, model);
		model.addAttribute("pageNum", p);
		
		model.addAttribute("menuname", "お問い合わせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/ask/askContent.jsp");
		
		return "/admin/index";
	}

	@PostMapping("/deletequestion/{p}/{checkVal}/{q_seq}/{pageNumber}")
	public String adminDeleteQuestion(@PathVariable("q_seq") String q_seq,
			@PathVariable(value = "p") int p
			, @PathVariable(value = "checkVal") String checkVal
			, @PathVariable("pageNumber") int pageNumber
			
			) {
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("p:");
		System.out.println(p);
		System.out.println("checkVal:");
		System.out.println(checkVal);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		if(questionadminservice.adminCommentDelete(q_seq) == 1) {
			System.out.println("comment delete 완료");
		}
		if(questionadminservice.adminQuestionDelete(q_seq) == 1) {
			System.out.println("question delete 완료");
		}
		
		if(p != pageNumber) {
			p = pageNumber;
		}
		
		return "redirect:/admin/boardManagement/question/" + p + "/" + checkVal ;
	}
	


	
	
}

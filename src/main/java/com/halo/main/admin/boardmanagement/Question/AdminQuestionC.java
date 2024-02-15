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
	
////	@ResponseBody
//	@GetMapping("/question")
//	public String AdminQuestionMain(
////			@RequestParam(value = "completed", required = false, defaultValue = "세션없음") String completed,
////			@RequestParam(value = "uncompleted", required = false, defaultValue = "세션없음") String uncompleted,
//			 Model model) {
//		
//		model.addAttribute("QnCs", questionadminservice.getAllQnCs());
//		questionadminservice.qaPaging(1, model);
//		
//		model.addAttribute("menuname", "お問い合わせ");
//		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/ask/askContent.jsp");
//
//		return "/admin/index";
//	}
	
	@GetMapping("/question/{checkVal}/{p}")
	public String AdminQuestionMainPaging(
//			@RequestParam(value = "completed", required = false, defaultValue = "세션없음") String completed,
//			@RequestParam(value = "uncompleted", required = false, defaultValue = "세션없음") String uncompleted,
			@PathVariable(value = "p") int p
			, @PathVariable(value = "checkVal") String checkVal
			, Model model) {
		
		
		model.addAttribute("QnCs", questionadminservice.getAllQnCs());
		questionadminservice.qaPaging(p, model);
		
		model.addAttribute("menuname", "お問い合わせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/ask/askContent.jsp");
		
		return "/admin/index";
	}

	

//	@GetMapping("/question/paging/{p}/{checkVal}")
//	public String AdminQuestionMain(@PathVariable("p") int p,@PathVariable("checkVal") boolean checkVal , Model model) {
//		
////		model.addAttribute("QnCs", questionadminmapper.getCheckboxedQuestions());
//		
//		model.addAttribute("menuname", "お問い合わせ");
//		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/ask/askContent.jsp");
//		
//		return "/admin/index";
//	}
	
	
}

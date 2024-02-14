package com.halo.main.admin.boardmanagement.Question;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminQuestionC {

	private QuestionAdminMapper questionadminmapper;
	
	@GetMapping("/admin/question")
	public String AdminQuestionMain(Model model) {
		
//		model.addAttribute("QnCs", questionadminmapper.getCheckboxedQuestions());
		
		model.addAttribute("menuname", "お問い合わせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/ask/askContent.jsp");

		return "/admin/index";
	}
	
	
}

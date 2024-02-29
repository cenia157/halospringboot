package com.halo.main.user.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.halo.main.user.common.HomepageDAO;



@Controller
public class QuestionC {

	@Autowired
	QuestionService questionservice;
	
	@Autowired
	private HomepageDAO homeDao;
	
	//전체
	@GetMapping("/qna/question")
	public String getAllQuestion(Model model) {
		
		model.addAttribute("QnCs", questionservice.getAllQnCPaging());
		questionservice.questionPaging(1, model);
		
		model.addAttribute("menu", "/views/user/menu-index.jsp");
		model.addAttribute("hdto", homeDao.getAllhomepage());
		model.addAttribute("subMenu", "/views/user/qa/question/question.jsp");
		return "index";
	}
	
	//전체 페이징 처리
	@GetMapping("/qna/question/{p}")
	public String getallQuestionPaging(@PathVariable(value = "p") int p, Model model) {
	    model.addAttribute("QnCs", questionservice.getAllQnCPaging());
	    questionservice.questionPaging(p, model);
	    
	    model.addAttribute("menu", "/views/user/menu-index.jsp");
	    model.addAttribute("hdto", homeDao.getAllhomepage());
	    model.addAttribute("subMenu", "/views/user/qa/question/question.jsp");
	    return "index";
	}
	
	
	//상세
	@GetMapping("/qna/question/detail/{q_seq}")
	public String getQuestionDetail(Model model, @PathVariable("q_seq") int q_seq) {
		model.addAttribute("QnC", questionservice.getQnC(q_seq));
		model.addAttribute("resultList", questionservice.getAllQnCs());
		model.addAttribute("questionId", q_seq);
		
		model.addAttribute("menu", "/views/user/menu-index.jsp");
		model.addAttribute("hdto", homeDao.getAllhomepage());
		model.addAttribute("subMenu", "/views/user/qa/question/questionDetail.jsp");
		return "index";
	}
	
	//insert
	@PostMapping("/QuestionSubmit")
	public String questionSubmit(QuestionVO questionVO) {
	    System.out.println("questionVO: "+ questionVO);
	    if(questionservice.insertquestion(questionVO)== 1) {
	        System.out.println("insert 성공");
	    }
	    return "redirect:/qna/question";
	}

	//detail
	@GetMapping("/QuestionDelete/{q_seq}")
	public String questionDelete (@PathVariable("q_seq") int q_seq) {
		if(questionservice.deletecomment(q_seq)==1) {
			System.out.println("comment delete 성공");
		}
		if(questionservice.deletequestion(q_seq)==1) {
			System.out.println("question delete 성공");
		}
		return "redirect:/qna/question";
	}
	
	
	
}

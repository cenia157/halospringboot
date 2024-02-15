package com.halo.main.admin.boardmanagement.Question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestBody;


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

	//detail: question
	@ResponseBody
	@PostMapping("/questiondetail/{q_seq}")
	public List<QuestionAdminVO> getQuestionDetail(@PathVariable("q_seq") int q_seq) {
		return questionadminservice.getQuestionDetail(q_seq);
	}
	//detail: comment
	@ResponseBody
	@PostMapping("/commentdetail/{q_seq}")
	public List<QuestionAdminVO> getCommentDetail(@PathVariable("q_seq") int q_seq) {
		return questionadminservice.getCommentDetail(q_seq);
	}
	
	
	//delete
	@PostMapping("/deletequestion/{p}/{checkVal}/{q_seq}/{pageNumber}")
	public String adminDeleteQuestion(@PathVariable("q_seq") String q_seq,
			@PathVariable(value = "p") int p
			, @PathVariable(value = "checkVal") String checkVal
			, @PathVariable("pageNumber") int pageNumber
			
			) {
		
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
	

	//detail modal insert
	@PostMapping("/commentsubmit/{p}/{checkVal}")
	public String adminInsertComment(
			@RequestParam("q_seq") int q_seq,
			@RequestParam("c_comment_content") String c_comment_content,
			@RequestParam("c_writer") String c_writer,
			@PathVariable(value = "p") int p,
			@PathVariable(value = "checkVal") String checkVal
			) {
		if(questionadminservice.adminInsertComment(q_seq, c_comment_content, c_writer) == 1) {
			System.out.println("submit 완료");
		}
		return "redirect:/admin/boardManagement/question/" + p + "/" + checkVal ;
	}
	
	//detail modal update
	@PostMapping("/commentupdate/{p}/{checkVal}")
	public String adminUpdateComment(
			@RequestParam("c_seq") int c_seq,
			@RequestParam("c_comment_content") String c_comment_content,
			@PathVariable(value = "p") int p,
			@PathVariable(value = "checkVal") String checkVal
			) {
		if(questionadminservice.adminUpdateComment(c_seq, c_comment_content) == 1) {
			System.out.println("Update 성공");
		}
		return "redirect:/admin/boardManagement/question/" + p + "/" + checkVal;
	}
	

	
	
}

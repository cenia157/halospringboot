package com.halo.main.admin.boardmanagement.FAQ;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.halo.main.user.faq.FAQVO;



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
	@PostMapping("/getFAQDetail")
	public List<FAQVO> getFAQDetail(@RequestBody FAQVO request) {
		
		int qa_seq = request.getQa_seq(); // 요청 객체에서 qaSeq를 가져옴
		return faqadminservice.getFAQListAdmin(qa_seq);
	}
	
//	@ResponseBody
//	@PostMapping("/admin/faq/update")
//	public String adminFAQUpdate(@RequestParam int qa_seq, @RequestParam String qa_title, @RequestParam String qa_content) {
//		if(faqadminservice.updateFAQListAdmin(qa_seq, qa_title, qa_content)==1) {
//			System.out.println("update 완료");
//		};
//		return "redirect:admin/faq";
//	}
	
	@PostMapping("/CkeditorC_Frequenthyask")
	public ResponseEntity<String> adminFAQUpdate(@RequestParam("seq") int qa_seq, @RequestParam("title") String qa_title, @RequestParam("txt") String qa_content) {
	    // 데이터 검증 로직

	    // 업데이트 로직
	    faqadminservice.updateFAQListAdmin(qa_seq, qa_title, qa_content);

	    // 성공 응답
	    return ResponseEntity.ok("업데이트 성공");
	}

	
	
	
}

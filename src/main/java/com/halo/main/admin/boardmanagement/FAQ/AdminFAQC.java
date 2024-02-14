package com.halo.main.admin.boardmanagement.FAQ;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
//	@PostMapping("/CkeditorC_Frequenthyask")
//	public ResponseEntity<String> adminFAQUpdate(@RequestParam("seq") int seq, // 'seq'로 변경
//	                                            @RequestParam("title") String title, // 'title'로 변경
//	                                            @RequestParam("content") String content) { // 'content'로 변경
//	    // 데이터 검증 로직
//		System.out.println("CKeditorC 들어옴");
//	    // 업데이트 로직
//	    faqadminservice.updateFAQListAdmin(seq, title, content); // 파라미터 이름 변경에 따라 수정
//
//	    // 성공 응답
//	    return ResponseEntity.ok("업데이트 성공");
//	}
	
	@PostMapping("/CkeditorC_Frequenthyask")
	public String handleFormData(@RequestBody FAQformDataVO requestData) {
	    // requestData 객체를 사용하여 원하는 작업 수행
	    // requestData 객체의 필드에는 txt, title, seq가 있을 것으로 가정합니다.
	    int qa_seq = requestData.getSeq();
	    String qa_title = requestData.getTitle();
	    String qa_content = requestData.getTxt();
	    
	    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
	    System.out.println(qa_seq);
	    System.out.println(qa_title);
	    System.out.println(qa_content);
	    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");

	    // 수행된 작업 후 리다이렉트 등의 응답
	    return "redirect:/admin/faq";
	}


	
	
	
}

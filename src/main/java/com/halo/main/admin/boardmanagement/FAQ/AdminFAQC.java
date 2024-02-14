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
	
	
	@PostMapping("/CkeditorC_Frequenthyask")
	public String handleFormData(@RequestBody FAQformDataVO requestData) {
	    // requestData 객체를 사용하여 원하는 작업 수행
	    // requestData 객체의 필드에는 txt, title, seq가 있을 것으로 가정합니다.
	    int seq = requestData.getSeq();
	    String title = requestData.getTitle();
	    String txt = requestData.getTxt();
	    
	    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
	    System.out.println(seq);
	    System.out.println(title);
	    System.out.println(txt);
	    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
	    
	    faqadminservice.updateFAQListAdmin(seq, title, txt);

	    // 수행된 작업 후 리다이렉트 등의 응답
	    return "redirect:/admin/faq";
	}


	
	
	
}

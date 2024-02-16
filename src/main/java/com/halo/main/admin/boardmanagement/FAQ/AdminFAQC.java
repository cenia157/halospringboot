package com.halo.main.admin.boardmanagement.FAQ;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.halo.main.user.faq.FAQVO;


@RequestMapping("/admin/boardManagement")
@Controller
public class AdminFAQC {

	@Autowired
	private FAQAdminService faqadminservice;
	
	@GetMapping("/faq")
	public String AdminFAQMain(Model model) {
		
		model.addAttribute("FAQs", faqadminservice.getAllFAQsAdmin());
		
		model.addAttribute("menuname", "よくある質問");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/frequenthyask/frequenthyaskContent.jsp");

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
	    
	    faqadminservice.updateFAQListAdmin(seq, title, txt);

	    // 수행된 작업 후 리다이렉트 등의 응답
	    return "redirect:/admin/boardManagement/faq";
	}
	
//	// 이미지 업로드
//	@ResponseBody
//	@PostMapping(value = "/faq/CKEditorImgUpload")
//	public ResponseEntity<?> uploadFile(@RequestParam("upload") MultipartFile file) {
//		return faqadminservice.uploadFile(file);
//	}
	
	@ResponseBody
	@PostMapping("/faq/CKEditorImgUpload")
    public String handleFileUpload(@RequestParam("upload") MultipartFile file) {
        if (file.isEmpty()) {
            return "업로드된 파일이 없습니다.";
        }

        try {
            // 파일을 저장하고 저장된 파일의 URL을 반환
            String fileName = file.getOriginalFilename();
            String filePath = "/path/to/save/uploads/" + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            return "파일 업로드가 완료되었습니다. 파일 URL: " + filePath;
        } catch (IOException e) {
            return "파일 업로드 중 오류가 발생했습니다: " + e.getMessage();
        }
    }

	

	
	
	
}

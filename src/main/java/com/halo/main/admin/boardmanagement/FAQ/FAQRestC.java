package com.halo.main.admin.boardmanagement.FAQ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.halo.main.user.faq.FAQService;
import com.halo.main.user.faq.FAQVO;

@RestController
public class FAQRestC {
	
	//userFAQ쪽으로 데이터 보내기
	  @Autowired // 의존성 주입
	  private FAQService faqService;
	  
	    @PostMapping("/loadFAQDetailContent")
	    public List<FAQVO> loadFAQDetailContent(@RequestBody FAQVO request) {
	        int qaSeq = request.getQa_seq(); // 요청 객체에서 qaSeq를 가져옴
	        return faqService.getFAQList(qaSeq);
	    }

}

package com.halo.main.admin.boardmanagement.FAQ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.halo.main.user.faq.FAQVO;

@Service
public class FAQAdminService {

	@Autowired
	private FAQAdminMapper faqadminmapper;
	
	public List<FAQVO> getAllFAQsAdmin() {
		return faqadminmapper.getAllFAQsAdmin();
	}

	public FAQVO getFAQDetail(int qa_seq) {
		return faqadminmapper.getFAQDetail(qa_seq);
	}

	public List<FAQVO> getFAQListAdmin(int qa_seq) {
		return faqadminmapper.getFAQListAdmin(qa_seq);
	}

	public int updateFAQListAdmin(int seq, String title, String txt) {
		return faqadminmapper.updateFAQListAdmin(seq, title, txt);
	}


	
}

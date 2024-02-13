package com.halo.main.admin.boardmanagement.FAQ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	
}

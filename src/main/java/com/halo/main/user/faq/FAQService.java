package com.halo.main.user.faq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class FAQService {

	@Autowired
	private FAQMapper faqmapper;
	
	public List<FAQVO> getAllFAQ() {
		return faqmapper.getAllFAQ();
	}

	public String getFAQDetail(int qa_seq) {
		return faqmapper.getFAQDetail(qa_seq);
	}

	public List<FAQVO> getFAQList(int qa_seq) {
		return faqmapper.getFAQList(qa_seq);
	}

}

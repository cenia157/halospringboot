package com.halo.main.user.faq;

import java.util.Date;

import lombok.Data;

@Data
public class FAQVO {

	private int qa_seq;
	private String qa_title;
	private String qa_content;
	private Date qa_reg_date;
	
}

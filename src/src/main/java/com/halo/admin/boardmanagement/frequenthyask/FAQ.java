package com.halo.admin.boardmanagement.frequenthyask;

import java.sql.Date;

public class FAQ {

	private int qa_seq;
	private String qa_title;
	private String qa_content;
	private Date qa_reg_date;
	
	public FAQ() {
		// TODO Auto-generated constructor stub
	}
	
	public FAQ(int qa_seq, String qa_title, String qa_content, Date qa_reg_date) {
		super();
		this.qa_seq = qa_seq;
		this.qa_title = qa_title;
		this.qa_content = qa_content;
		this.qa_reg_date = qa_reg_date;
	}

	public int getQa_seq() {
		return qa_seq;
	}

	public void setQa_seq(int qa_seq) {
		this.qa_seq = qa_seq;
	}

	public String getQa_title() {
		return qa_title;
	}

	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}

	public String getQa_content() {
		return qa_content;
	}

	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}

	public Date getQa_reg_date() {
		return qa_reg_date;
	}

	public void setQa_reg_date(Date qa_reg_date) {
		this.qa_reg_date = qa_reg_date;
	}
	
}

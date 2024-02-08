package com.halo.admin.boardmanagement.ask;

import java.sql.Date;

public class Comment {

	private int c_seq;
	private String c_commenter_name;
	private String c_comment_content;
	private Date c_reg_date;
	private String c_answer;
	private int q_seq;
	
	
	public Comment(int c_seq, String c_commenter_name, String c_comment_content, Date c_reg_date, String c_answer,
			int q_seq) {
		super();
		this.c_seq = c_seq;
		this.c_commenter_name = c_commenter_name;
		this.c_comment_content = c_comment_content;
		this.c_reg_date = c_reg_date;
		this.c_answer = c_answer;
		this.q_seq = q_seq;
	}


	public int getC_seq() {
		return c_seq;
	}


	public void setC_seq(int c_seq) {
		this.c_seq = c_seq;
	}


	public String getC_commenter_name() {
		return c_commenter_name;
	}


	public void setC_commenter_name(String c_commenter_name) {
		this.c_commenter_name = c_commenter_name;
	}


	public String getC_comment_content() {
		return c_comment_content;
	}


	public void setC_comment_content(String c_comment_content) {
		this.c_comment_content = c_comment_content;
	}


	public Date getC_reg_date() {
		return c_reg_date;
	}


	public void setC_reg_date(Date c_reg_date) {
		this.c_reg_date = c_reg_date;
	}


	public String getC_answer() {
		return c_answer;
	}


	public void setC_answer(String c_answer) {
		this.c_answer = c_answer;
	}


	public int getQ_seq() {
		return q_seq;
	}


	public void setQ_seq(int q_seq) {
		this.q_seq = q_seq;
	}


	@Override
	public String toString() {
		return "Comment [c_seq=" + c_seq + ", c_commenter_name=" + c_commenter_name + ", c_comment_content="
				+ c_comment_content + ", c_reg_date=" + c_reg_date + ", c_answer=" + c_answer + ", q_seq=" + q_seq
				+ "]";
	}
	
	
	
	
	
}

package com.halo.admin.boardmanagement.ask;

import java.sql.Date;

import com.google.gson.Gson;

public class QuestionNComment {

    // Comment 속성
    private int c_seq;
    private String c_commenter_name;
    private String c_comment_content;
    private Date c_reg_date;
    private String c_answer;

    // Question 속성
    private int q_seq;
    private String q_title;
    private String q_content;
    private Date q_reg_date;
    private String q_contact_number;
    private String q_email;
    private String q_name;
    private String q_password;
    private String q_category;

    public QuestionNComment() {
	}

	public QuestionNComment(int c_seq, String c_commenter_name, String c_comment_content, Date c_reg_date,
			String c_answer, int q_seq, String q_title, String q_content, Date q_reg_date, String q_contact_number,
			String q_email, String q_name, String q_password, String q_category) {
		super();
		this.c_seq = c_seq;
		this.c_commenter_name = c_commenter_name;
		this.c_comment_content = c_comment_content;
		this.c_reg_date = c_reg_date;
		this.c_answer = c_answer;
		this.q_seq = q_seq;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_reg_date = q_reg_date;
		this.q_contact_number = q_contact_number;
		this.q_email = q_email;
		this.q_name = q_name;
		this.q_password = q_password;
		this.q_category = q_category;
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

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public Date getQ_reg_date() {
		return q_reg_date;
	}

	public void setQ_reg_date(Date q_reg_date) {
		this.q_reg_date = q_reg_date;
	}

	public String getQ_contact_number() {
		return q_contact_number;
	}

	public void setQ_contact_number(String q_contact_number) {
		this.q_contact_number = q_contact_number;
	}

	public String getQ_email() {
		return q_email;
	}

	public void setQ_email(String q_email) {
		this.q_email = q_email;
	}

	public String getQ_name() {
		return q_name;
	}

	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}

	public String getQ_password() {
		return q_password;
	}

	public void setQ_password(String q_password) {
		this.q_password = q_password;
	}

	public String getQ_category() {
		return q_category;
	}

	public void setQ_category(String q_category) {
		this.q_category = q_category;
	}

	@Override
	public String toString() {
		return "QuestionNComment [c_seq=" + c_seq + ", c_commenter_name=" + c_commenter_name + ", c_comment_content="
				+ c_comment_content + ", c_reg_date=" + c_reg_date + ", c_answer=" + c_answer + ", q_seq=" + q_seq
				+ ", q_title=" + q_title + ", q_content=" + q_content + ", q_reg_date=" + q_reg_date
				+ ", q_contact_number=" + q_contact_number + ", q_email=" + q_email + ", q_name=" + q_name
				+ ", q_password=" + q_password + ", q_category=" + q_category + "]";
	}
    
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
    
}

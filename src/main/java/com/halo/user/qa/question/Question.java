package com.halo.user.qa.question;

import java.sql.Date;

public class Question {
	
	private int q_seq;
	private String q_title;
	private String q_content;
	private Date q_reg_date;
	private String q_contact_number;
	private String q_email;
	private String q_name;
	private String q_password;
	private String q_category;
	
	public Question() {
	}

	public Question(int q_seq, String q_title, String q_content, Date q_reg_date, String q_contact_number, String q_email,
			String q_name, String q_password, String q_category) {
		super();
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
		return "Question [q_seq=" + q_seq + ", q_title=" + q_title + ", q_content=" + q_content + ", q_reg_date="
				+ q_reg_date + ", q_contact_number=" + q_contact_number + ", q_email=" + q_email + ", q_name=" + q_name
				+ ", q_password=" + q_password + ", q_category=" + q_category + "]";
	}
	
	
}

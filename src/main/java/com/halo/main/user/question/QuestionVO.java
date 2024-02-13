package com.halo.main.user.question;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionVO {

	private int q_seq;
	private String q_title;
	private String q_content;
	private Date q_reg_date;
	private String q_contact_number;
	private String q_email;
	private String q_name;
	private String q_password;
	private String q_category;
	
}

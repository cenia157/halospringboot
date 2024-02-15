package com.halo.main.admin.boardmanagement.Question;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionAdminVO {
	
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
    
}

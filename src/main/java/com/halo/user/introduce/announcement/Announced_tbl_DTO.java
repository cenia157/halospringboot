package com.halo.user.introduce.announcement;

import java.util.Date;

public class Announced_tbl_DTO {
    private int an_seq;
    private String an_title;
    private String an_content;
    private String an_writer;
    private Date an_reg_date;
    private String an_category;
    private String an_img;
    
    public Announced_tbl_DTO() {}

	public Announced_tbl_DTO(int an_seq, String an_title, String an_content, String an_writer, Date an_reg_date,
			String an_category, String an_img) {
		super();
		this.an_seq = an_seq;
		this.an_title = an_title;
		this.an_content = an_content;
		this.an_writer = an_writer;
		this.an_reg_date = an_reg_date;
		this.an_category = an_category;
		this.an_img = an_img;
	}

	public int getAn_seq() {
		return an_seq;
	}

	public void setAn_seq(int an_seq) {
		this.an_seq = an_seq;
	}

	public String getAn_title() {
		return an_title;
	}

	public void setAn_title(String an_title) {
		this.an_title = an_title;
	}

	public String getAn_content() {
		return an_content;
	}

	public void setAn_content(String an_content) {
		this.an_content = an_content;
	}

	public String getAn_writer() {
		return an_writer;
	}

	public void setAn_writer(String an_writer) {
		this.an_writer = an_writer;
	}

	public Date getAn_reg_date() {
		return an_reg_date;
	}

	public void setAn_reg_date(Date an_reg_date) {
		this.an_reg_date = an_reg_date;
	}

	public String getAn_category() {
		return an_category;
	}

	public void setAn_category(String an_category) {
		this.an_category = an_category;
	}

	public String getAn_img() {
		return an_img;
	}

	public void setAn_img(String an_img) {
		this.an_img = an_img;
	}

	@Override
	public String toString() {
		return "Announced_tbl_DTO [an_seq=" + an_seq + ", an_title=" + an_title + ", an_content=" + an_content
				+ ", an_writer=" + an_writer + ", an_reg_date=" + an_reg_date + ", an_category=" + an_category
				+ ", an_img=" + an_img + "]";
	}
    
	
}

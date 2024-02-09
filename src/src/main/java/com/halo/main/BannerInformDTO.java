package com.halo.main;

public class BannerInformDTO {
	private int b_index;
	private int b_type;
	private String b_m_name;
	private String b_url;
	private String b_m_text;
	private String b_img_url;
	
	public BannerInformDTO() {
		// TODO Auto-generated constructor stub
	}

	public BannerInformDTO(int b_index, int b_type, String b_m_name, String b_url, String b_m_text, String b_img_url) {
		super();
		this.b_index = b_index;
		this.b_type = b_type;
		this.b_m_name = b_m_name;
		this.b_url = b_url;
		this.b_m_text = b_m_text;
		this.b_img_url = b_img_url;
	}

	public int getB_index() {
		return b_index;
	}

	public void setB_index(int b_index) {
		this.b_index = b_index;
	}

	public int getB_type() {
		return b_type;
	}

	public void setB_type(int b_type) {
		this.b_type = b_type;
	}

	public String getB_m_name() {
		return b_m_name;
	}

	public void setB_m_name(String b_m_name) {
		this.b_m_name = b_m_name;
	}

	public String getB_url() {
		return b_url;
	}

	public void setB_url(String b_url) {
		this.b_url = b_url;
	}

	public String getB_m_text() {
		return b_m_text;
	}

	public void setB_m_text(String b_m_text) {
		this.b_m_text = b_m_text;
	}

	public String getB_img_url() {
		return b_img_url;
	}

	public void setB_img_url(String b_img_url) {
		this.b_img_url = b_img_url;
	}

	@Override
	public String toString() {
		return "BannerInformDTO [b_index=" + b_index + ", b_type=" + b_type + ", b_m_name=" + b_m_name + ", b_url=" + b_url
				+ ", b_m_text=" + b_m_text + ", b_img_url=" + b_img_url + "]";
	}
	
	
}

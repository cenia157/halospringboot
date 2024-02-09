package com.halo.main;

public class PopupDTO {
	private String p_img;
	private String p_url;
	private int p_flag;
	private String m_text;

	 public PopupDTO() {
		// TODO Auto-generated constructor stub
	}

	public PopupDTO(String p_img, String p_url, int p_flag, String m_text) {
		super();
		this.p_img = p_img;
		this.p_url = p_url;
		this.p_flag = p_flag;
		this.m_text = m_text;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getP_url() {
		return p_url;
	}

	public void setP_url(String p_url) {
		this.p_url = p_url;
	}

	public int getP_flag() {
		return p_flag;
	}

	public void setP_flag(int p_flag) {
		this.p_flag = p_flag;
	}

	public String getM_text() {
		return m_text;
	}

	public void setM_text(String m_text) {
		this.m_text = m_text;
	}

	@Override
	public String toString() {
		return "PopupDTO [p_img=" + p_img + ", p_url=" + p_url + ", p_flag=" + p_flag + ", m_text=" + m_text + "]";
	}
	 
	 



}
	
	
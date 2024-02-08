package com.halo.admin.login;

public class AdminDTO {
	
	private String a_id;
	private String a_pw;
	private String a_name;
	
	
	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}


	public AdminDTO(String a_id, String a_pw, String a_name) {
		super();
		this.a_id = a_id;
		this.a_pw = a_pw;
		this.a_name = a_name;
	}


	public String getA_id() {
		return a_id;
	}


	public void setA_id(String a_id) {
		this.a_id = a_id;
	}


	public String getA_pw() {
		return a_pw;
	}


	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}


	public String getA_name() {
		return a_name;
	}


	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	
	
	

}

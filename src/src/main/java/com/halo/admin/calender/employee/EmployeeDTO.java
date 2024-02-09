package com.halo.admin.calender.employee;

import com.google.gson.Gson;

public class EmployeeDTO {
	
	private int s_no;
	private String s_position;
	private String s_name;
	private String s_phone_num;
	private String s_entry_date;
	private String s_color;
	private String s_addr;

	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}


	public EmployeeDTO(int s_no, String s_position, String s_name, String s_phone_num, String s_entry_date, String s_color,
			String s_addr) {
		super();
		this.s_no = s_no;
		this.s_position = s_position;
		this.s_name = s_name;
		this.s_phone_num = s_phone_num;
		this.s_entry_date = s_entry_date;
		this.s_color = s_color;
		this.s_addr = s_addr;
	}


	public int getS_no() {
		return s_no;
	}


	public void setS_no(int s_no) {
		this.s_no = s_no;
	}


	public String getS_position() {
		return s_position;
	}


	public void setS_position(String s_position) {
		this.s_position = s_position;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public String getS_phone_num() {
		return s_phone_num;
	}


	public void setS_phone_num(String s_phone_num) {
		this.s_phone_num = s_phone_num;
	}


	public String getS_entry_date() {
		return s_entry_date;
	}


	public void setS_entry_date(String s_entry_date) {
		this.s_entry_date = s_entry_date;
	}


	public String getS_color() {
		return s_color;
	}


	public void setS_color(String s_color) {
		this.s_color = s_color;
	}


	public String getS_addr() {
		return s_addr;
	}


	public void setS_addr(String s_addr) {
		this.s_addr = s_addr;
	}


	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	
}

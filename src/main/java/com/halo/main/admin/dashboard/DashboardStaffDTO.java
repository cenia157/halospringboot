package com.halo.main.admin.dashboard;

import com.google.gson.Gson;

public class DashboardStaffDTO {
	private int f_no;
	private String f_year;
	private String f_month;
	private String f_dates;
	private String s_position;
	private String s_name;
	private String s_phone_num;
	private String s_addr;
	
	public DashboardStaffDTO() {
		// TODO Auto-generated constructor stub
	}

	public DashboardStaffDTO(int f_no, String f_year, String f_month, String f_dates, String s_position, String s_name,
			String s_phone_num, String s_addr) {
		super();
		this.f_no = f_no;
		this.f_year = f_year;
		this.f_month = f_month;
		this.f_dates = f_dates;
		this.s_position = s_position;
		this.s_name = s_name;
		this.s_phone_num = s_phone_num;
		this.s_addr = s_addr;
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public String getF_year() {
		return f_year;
	}

	public void setF_year(String f_year) {
		this.f_year = f_year;
	}

	public String getF_month() {
		return f_month;
	}

	public void setF_month(String f_month) {
		this.f_month = f_month;
	}

	public String getF_dates() {
		return f_dates;
	}

	public void setF_dates(String f_dates) {
		this.f_dates = f_dates;
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

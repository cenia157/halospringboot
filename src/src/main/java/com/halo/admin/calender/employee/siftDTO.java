package com.halo.admin.calender.employee;

import com.google.gson.Gson;

public class siftDTO {
	private int f_no;
	private String f_year;
	private String f_month;
	private String f_dates;
	private int f_staffNo;

	public siftDTO() {
		// TODO Auto-generated constructor stub
	}

	public siftDTO(int f_no, String f_year, String f_month, String f_dates, int f_staffNo) {
		super();
		this.f_no = f_no;
		this.f_year = f_year;
		this.f_month = f_month;
		this.f_dates = f_dates;
		this.f_staffNo = f_staffNo;
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

	public int getF_staffNo() {
		return f_staffNo;
	}

	public void setF_staffNo(int f_staffNo) {
		this.f_staffNo = f_staffNo;
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}

package com.halo.admin.calender.company;

import com.google.gson.Gson;

public class CompanyScheduleDTO {
	private String year;
	private String month;
	private String title;
	private String txt;
	private String date;
	private String update;
	private String no;

	public CompanyScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public CompanyScheduleDTO(String year, String month, String title, String txt, String date, String update,
			String no) {
		super();
		this.year = year;
		this.month = month;
		this.title = title;
		this.txt = txt;
		this.date = date;
		this.update = update;
		this.no = no;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}

package com.halo.admin.calender.reservation;

import com.google.gson.Gson;

public class StaffDTO {
	private String name;

	public StaffDTO() {
		// TODO Auto-generated constructor stub
	}

	public StaffDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

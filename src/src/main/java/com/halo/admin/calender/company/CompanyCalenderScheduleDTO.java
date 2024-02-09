package com.halo.admin.calender.company;

public class CompanyCalenderScheduleDTO {
	private String cTitle;
	private String cYearMonth;
	private String cDate;
	
	public CompanyCalenderScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public CompanyCalenderScheduleDTO(String cTitle, String cYearMonth, String cDate) {
		super();
		this.cTitle = cTitle;
		this.cYearMonth = cYearMonth;
		this.cDate = cDate;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcYearMonth() {
		return cYearMonth;
	}

	public void setcYearMonth(String cYearMonth) {
		this.cYearMonth = cYearMonth;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	
	
}

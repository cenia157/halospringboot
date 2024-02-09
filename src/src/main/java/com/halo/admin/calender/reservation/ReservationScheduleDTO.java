package com.halo.admin.calender.reservation;

import com.google.gson.Gson;

public class ReservationScheduleDTO {
	private String no;
	private String applicant;
	private String phoneNumber;
	private String userName;
	private String gender;
	private String birthDates;
	private String year;
	private String month;
	private String dates;
	private String time;
	private String addr;
	private String startPoint;
	private String endPoint;
	private String nurssingInfo;
	private String taxiInfo;
	private String registrationDate;
	private String service;

	public ReservationScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReservationScheduleDTO(String no, String applicant, String phoneNumber, String userName, String gender,
			String birthDates, String year, String month, String dates, String time, String addr, String startPoint,
			String endPoint, String nurssingInfo, String taxiInfo, String registrationDate, String service) {
		super();
		this.no = no;
		this.applicant = applicant;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.gender = gender;
		this.birthDates = birthDates;
		this.year = year;
		this.month = month;
		this.dates = dates;
		this.time = time;
		this.addr = addr;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.nurssingInfo = nurssingInfo;
		this.taxiInfo = taxiInfo;
		this.registrationDate = registrationDate;
		this.service = service;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDates() {
		return birthDates;
	}

	public void setBirthDates(String birthDates) {
		this.birthDates = birthDates;
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

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getNurssingInfo() {
		return nurssingInfo;
	}

	public void setNurssingInfo(String nurssingInfo) {
		this.nurssingInfo = nurssingInfo;
	}

	public String gettaxiInfo() {
		return taxiInfo;
	}

	public void settaxiInfo(String taxiInfo) {
		this.taxiInfo = taxiInfo;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

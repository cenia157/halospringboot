package com.halo.admin.calender.reservation;

import com.google.gson.Gson;

public class ReservationScheduleAcceptDTO {
	private String pkNo;
	private String applicant;
	private String service;
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
	private String carNum;
	private String feedBack;
	private String registrationDate;
	private String staff;
	private String joinNo;

	public ReservationScheduleAcceptDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReservationScheduleAcceptDTO(String pkNo, String applicant, String service, String phoneNumber,
			String userName, String gender, String birthDates, String year, String month, String dates, String time,
			String addr, String startPoint, String endPoint, String carNum, String feedBack, String registrationDate,
			String staff, String joinNo) {
		super();
		this.pkNo = pkNo;
		this.applicant = applicant;
		this.service = service;
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
		this.carNum = carNum;
		this.feedBack = feedBack;
		this.registrationDate = registrationDate;
		this.staff = staff;
		this.joinNo = joinNo;
	}

	public String getPkNo() {
		return pkNo;
	}

	public void setPkNo(String pkNo) {
		this.pkNo = pkNo;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
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

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getJoinNo() {
		return joinNo;
	}

	public void setJoinNo(String joinNo) {
		this.joinNo = joinNo;
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

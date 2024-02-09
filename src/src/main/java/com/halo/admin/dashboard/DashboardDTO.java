package com.halo.admin.dashboard;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.halo.admin.boardmanagement.ask.QuestionNComment;
import com.halo.admin.calender.company.CompanyScheduleDTO;
import com.halo.admin.calender.reservation.ReservationScheduleAcceptDTO;

public class DashboardDTO {
	private ArrayList<ReservationScheduleAcceptDTO> reservationAccpectSchedule;
	private ArrayList<CompanyScheduleDTO> companySchedule;
	private ArrayList<DashboardStaffDTO> staffSchedule;
	private ArrayList<QuestionNComment> unAnswered;
	
	public DashboardDTO() {
		// TODO Auto-generated constructor stub
	}

	public DashboardDTO(ArrayList<ReservationScheduleAcceptDTO> reservationAccpectSchedule,
			ArrayList<CompanyScheduleDTO> companySchedule, ArrayList<DashboardStaffDTO> staffSchedule,
			ArrayList<QuestionNComment> unAnswered) {
		super();
		this.reservationAccpectSchedule = reservationAccpectSchedule;
		this.companySchedule = companySchedule;
		this.staffSchedule = staffSchedule;
		this.unAnswered = unAnswered;
	}

	public ArrayList<ReservationScheduleAcceptDTO> getReservationAccpectSchedule() {
		return reservationAccpectSchedule;
	}

	public void setReservationAccpectSchedule(ArrayList<ReservationScheduleAcceptDTO> reservationAccpectSchedule) {
		this.reservationAccpectSchedule = reservationAccpectSchedule;
	}

	public ArrayList<CompanyScheduleDTO> getCompanySchedule() {
		return companySchedule;
	}

	public void setCompanySchedule(ArrayList<CompanyScheduleDTO> companySchedule) {
		this.companySchedule = companySchedule;
	}

	public ArrayList<DashboardStaffDTO> getStaffSchedule() {
		return staffSchedule;
	}

	public void setStaffSchedule(ArrayList<DashboardStaffDTO> staffSchedule) {
		this.staffSchedule = staffSchedule;
	}

	public ArrayList<QuestionNComment> getUnAnswered() {
		return unAnswered;
	}

	public void setUnAnswered(ArrayList<QuestionNComment> unAnswered) {
		this.unAnswered = unAnswered;
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}

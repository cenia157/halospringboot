package com.halo.main.admin.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationScheduleAcceptDTO {
	private int sa_seq;
	private String sa_applicant;
	private String sa_service;
	private String sa_phone_number;
	private String sa_user_name;
	private String sa_gender;
	private String sa_birth_date;
	private String sa_year;
	private String sa_month;
	private String sa_days;
	private String sa_time;
	private String sa_addr;
	private String sa_start_place;
	private String sa_end_place;
	private String sa_car_no;
	private String sa_feedback;
	private String sa_registration_date;
	private String sa_staff;
	private int sa_no;

}

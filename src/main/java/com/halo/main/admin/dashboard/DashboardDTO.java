package com.halo.main.admin.dashboard;

import java.util.ArrayList;

import com.halo.main.admin.company.CompanyScheduleDTO;
import com.halo.main.admin.reservation.ReservationScheduleAcceptDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DashboardDTO {
	
	private ArrayList<ReservationScheduleAcceptDTO> reservationAccpectSchedule;
	private ArrayList<CompanyScheduleDTO> companySchedule;
	private ArrayList<DashboardStaffDTO> staffSchedule;
//	private ArrayList<QuestionNComment> unAnswered;
	
}

package com.halo.main.admin.dashboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.main.admin.company.CompanyScheduleDTO;
import com.halo.main.admin.reservation.ReservationScheduleAcceptDTO;

@Service
public class DashboardService {
	
	@Autowired
	private DashboardMapper dMapper;
	
	public ArrayList<CompanyScheduleDTO> getCompanySchedule(DashboardDate dDATE) {
		return dMapper.getCompanySchedule(dDATE);
	}
	
	public ArrayList<ReservationScheduleAcceptDTO> getReservationAccpectSchedule(DashboardDate dDATE) {
		return dMapper.getReservationAccpectSchedule(dDATE);
	}
	
	public ArrayList<DashboardStaffDTO> getStaffSchedule(DashboardDate dDATE) {
		return dMapper.getStaffSchedule(dDATE);
	}
	
//	public ArrayList<QuestionNComment> getUnAnsweredFaq() {
//		return dMapper.getUnAnsweredFaq();
//	}
	
	public DashboardDTO getDashboardData(DashboardDate dDATE) {
		DashboardDTO dDTO = new DashboardDTO();
		dDTO.setCompanySchedule(getCompanySchedule(dDATE)); 
		dDTO.setReservationAccpectSchedule(getReservationAccpectSchedule(dDATE));
		dDTO.setStaffSchedule(getStaffSchedule(dDATE));
		return dDTO; 
	}

}

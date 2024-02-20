package com.halo.main.admin.dashboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.main.admin.company.CompanyScheduleDTO;
import com.halo.main.admin.reservation.ReservationScheduleAcceptDTO;
import com.halo.main.user.question.QuestionNCommentsVO;
import com.halo.main.user.question.QuestionVO;

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
	
	public ArrayList<QuestionNCommentsVO> getUnAnsweredFaq() {
		return dMapper.getUnAnsweredFaq();
	}
	
	public DashboardDTO getDashboardData(DashboardDate dDATE) {
		DashboardDTO dDTO = new DashboardDTO();
		dDTO.setCompanySchedule(getCompanySchedule(dDATE)); 
		dDTO.setReservationAccpectSchedule(getReservationAccpectSchedule(dDATE));
		dDTO.setStaffSchedule(getStaffSchedule(dDATE));
		dDTO.setUnAnswered(getUnAnsweredFaq());
		return dDTO; 
	}

}

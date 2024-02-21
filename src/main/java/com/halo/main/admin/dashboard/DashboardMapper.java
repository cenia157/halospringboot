package com.halo.main.admin.dashboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.halo.main.admin.company.CompanyScheduleDTO;
import com.halo.main.admin.reservation.ReservationScheduleAcceptDTO;
import com.halo.main.user.question.QuestionNCommentsVO;
import com.halo.main.user.question.QuestionVO;

@Mapper
public interface DashboardMapper {
	
	@Select("select * from company_schedule where cs_year like #{year} and cs_month like #{month}")
	ArrayList<CompanyScheduleDTO> getCompanySchedule(DashboardDate dDATE);
	
	@Select("select * from reservation_information_accept where sa_year like #{year} and  sa_month like #{month}")
	ArrayList<ReservationScheduleAcceptDTO> getReservationAccpectSchedule(DashboardDate dDATE);

	@Select("select * from staff_sift left outer join staff_info on s_no = f_staffno where f_month = #{month}")
	ArrayList<DashboardStaffDTO> getStaffSchedule(DashboardDate dDATE);
	
	@Select("SELECT q.*, c.* FROM question_tbl q LEFT JOIN comment_tbl c ON q.q_seq = c.q_seq WHERE c.c_answer IS NULL ORDER BY q.q_reg_date")
	ArrayList<QuestionNCommentsVO> getUnAnsweredFaq();
}

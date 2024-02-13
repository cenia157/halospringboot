package com.halo.main.admin.reservation;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReservationMapper {
	
	@Select("select * from staff_info")
	List<StaffDTO> getgetStaffList();
	
	@Select("select * from reservation_information")
	List<ReservationScheduleDTO> getInformList();
	
	@Select("select * from reservation_information_accept")
	List<ReservationScheduleAcceptDTO> getAcceptList();
	
	@Insert("INSERT INTO reservation_information_accept (sa_seq, sa_applicant, sa_service, sa_phone_number, sa_user_name, sa_gender, sa_birth_date, sa_year, sa_month, sa_days, sa_time, sa_addr, sa_start_place, sa_end_place, sa_car_no, sa_feedback, sa_registration_date, sa_staff, sa_no ) VALUES (reservation_information_accept_seq.nextval, #{sa_applicant}, #{sa_service}, #{sa_phone_number}, #{sa_user_name}, #{sa_gender}, #{sa_birth_date}, #{sa_year}, #{sa_month}, #{sa_days}, #{sa_time}, #{sa_addr}, #{sa_start_place}, #{sa_end_place}, #{sa_car_no}, #{sa_feedback}, #{sa_registration_date}, #{sa_staff}, #{sa_seq})")
	int reservationAccept(ReservationScheduleDTO rsDTO);
	
	@Insert("INSERT INTO reservation_information_decline (sa_seq, sa_applicant, sa_service, sa_phone_number, sa_user_name, sa_gender, sa_birth_date, sa_year, sa_month, sa_days, sa_time, sa_addr, sa_start_place, sa_end_place, sa_car_no, sa_feedback, sa_registration_date, sa_staff, sa_no ) VALUES (reservation_information_decline_seq.nextval, #{sa_applicant}, #{sa_service}, #{sa_phone_number}, #{sa_user_name}, #{sa_gender}, #{sa_birth_date}, #{sa_year}, #{sa_month}, #{sa_days}, #{sa_time}, #{sa_addr}, #{sa_start_place}, #{sa_end_place}, #{sa_car_no}, #{sa_feedback}, #{sa_registration_date}, #{sa_staff}, #{sa_seq})")
	int reservationDecline(ReservationScheduleDTO rsDTO);
	
	@Delete("delete reservation_information where sa_seq = #{sa_seq}")
	int deleteInform(ReservationScheduleDTO rsDTO);
	
	@Update("update reservation_information_accept set sa_service = #{sa_service}, sa_user_name = #{sa_user_name}, sa_days = #{sa_days}, sa_addr = #{sa_addr}, sa_start_place = #{sa_start_place}, sa_end_place = #{sa_end_place}, sa_feedback = #{sa_feedback}, sa_staff = #{sa_staff}, sa_phone_number = #{sa_phone_number}, sa_time = #{sa_time}  where sa_seq = #{sa_seq}")
	int reservationUpdate(ReservationScheduleAcceptDTO rsDTO);
	
	@Delete("delete reservation_information_accept where sa_seq = #{sa_seq}")
	int reservationDelete(ReservationScheduleAcceptDTO rsaDTO);
	
	@Insert("INSERT INTO reservation_information_decline (sa_seq, sa_applicant, sa_service, sa_phone_number, sa_user_name, sa_gender, sa_birth_date, sa_year, sa_month, sa_days, sa_time, sa_addr, sa_start_place, sa_end_place, sa_car_no, sa_feedback, sa_registration_date, sa_staff, sa_no ) VALUES (reservation_information_decline_seq.nextval, #{sa_applicant}, #{sa_service}, #{sa_phone_number}, #{sa_user_name}, #{sa_gender}, #{sa_birth_date}, #{sa_year}, #{sa_month}, #{sa_days}, #{sa_time}, #{sa_addr}, #{sa_start_place}, #{sa_end_place}, #{sa_car_no}, #{sa_feedback}, #{sa_registration_date}, #{sa_staff}, #{sa_no})")
	int acceptToDecline(ReservationScheduleAcceptDTO rsaDTO);
	
	@Insert("INSERT INTO reservation_information_accept (SA_SEQ, SA_APPLICANT, SA_SERVICE, SA_PHONE_NUMBER, SA_USER_NAME, SA_GENDER, SA_BIRTH_DATE, SA_YEAR, SA_MONTH, SA_DAYS, SA_TIME, SA_ADDR, SA_START_PLACE, SA_END_PLACE, SA_CAR_NO, SA_FEEDBACK, SA_REGISTRATION_DATE, SA_STAFF, SA_NO)VALUES (reservation_information_accept_seq.nextval, '管理者', #{sa_service}, #{sa_phone_number}, #{sa_user_name}, 'n', '0000', #{sa_year}, #{sa_month}, #{sa_days}, #{sa_time}, #{sa_addr}, #{sa_start_place}, #{sa_end_place}, '0000', #{sa_feedback}, #{sa_registration_date}, #{sa_staff}, 999)")
	int reservationInsert(ReservationScheduleAcceptDTO rsaDTO);

}

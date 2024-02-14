package com.halo.main.user.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.halo.main.admin.reservation.ReservationScheduleDTO;

@Mapper
public interface ServiceMapper {

	@Insert("INSERT INTO reservation_information values(reservation_information_seq.nextval, #{sa_service}, #{sa_applicant}, #{sa_phone_number}, #{sa_user_name}, #{sa_gender}, #{sa_birth_date}, #{sa_year}, #{sa_month}, #{sa_days}, #{sa_time}, #{sa_addr}, #{sa_start_place}, #{sa_end_place}, 'N', null, #{sa_nursing_info}, #{sa_taxi_info}, 'N', null,  SYSDATE)")
	int serviceApply(ReservationScheduleDTO rsDTO);

	
	
	
}

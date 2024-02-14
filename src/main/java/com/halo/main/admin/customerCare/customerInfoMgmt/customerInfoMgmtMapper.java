package com.halo.main.admin.customerCare.customerInfoMgmt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.halo.main.admin.reservation.ReservationScheduleAcceptDTO;

@Mapper
public interface customerInfoMgmtMapper {

	@Select("select * from reservation_information_accept order by sa_seq desc")
	List<ReservationScheduleAcceptDTO> getCustomerInfo();

}

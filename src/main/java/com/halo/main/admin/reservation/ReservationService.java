package com.halo.main.admin.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationMapper rMapper;

	public List<StaffDTO> getStaffList() {
		return rMapper.getgetStaffList();
	}

	public List<ReservationScheduleDTO> getInformList() {
		return rMapper.getInformList();
	}

	public List<ReservationScheduleAcceptDTO> getAcceptList() {
		return rMapper.getAcceptList();
	}

	public int reservationAccept(ReservationScheduleDTO rsDTO) {
		return rMapper.reservationAccept(rsDTO);
	}

	public int reservationDecline(ReservationScheduleDTO rsDTO) {
		return rMapper.reservationDecline(rsDTO);
	}
	
	public int deleteInform(ReservationScheduleDTO rsDTO) {
		return rMapper.deleteInform(rsDTO);
	}

	public int reservationUpdate(ReservationScheduleAcceptDTO rsaDTO) {
		return rMapper.reservationUpdate(rsaDTO);
	}

	public int reservationDelete(ReservationScheduleAcceptDTO rsaDTO) {
		return rMapper.reservationDelete(rsaDTO);
	}

	public int acceptToDecline(ReservationScheduleAcceptDTO rsaDTO) {
		return rMapper.acceptToDecline(rsaDTO);
	}

	public int reservationInsert(ReservationScheduleAcceptDTO rsaDTO) {
		return rMapper.reservationInsert(rsaDTO);
	}

}

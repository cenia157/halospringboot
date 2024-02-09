package com.halo.main.admin.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyMapper cMapper;
	
	public List<CompanyScheduleDTO> getCompanyScheduleList() {
		return cMapper.getCompanyScheduleList();
	}

	public int insertCompanySchedule(CompanyScheduleDTO csDTO) {
		return cMapper.insertCompanySchedule(csDTO);
	}

	public int updateTxtCompanySchedule(CompanyScheduleDTO csDTO) {
		return cMapper.updateTxtCompanySchedule(csDTO);
	}

	public int deleteCompanySchedule(CompanyScheduleDTO csDTO) {
		return cMapper.deleteCompanySchedule(csDTO);
	}

	public int deleteRowCompanySchedule(CompanyScheduleDTO csDTO) {
		return cMapper.deleteRowCompanySchedule(csDTO);
	}
	
	
	
}

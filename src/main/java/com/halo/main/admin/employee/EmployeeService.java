package com.halo.main.admin.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper eMapper;

	public List<EmployeeDTO> getEmployeerList() {
		return eMapper.getEmployeerList();
	}

	public List<SiftDTO> getEmployeerSift() {
		return eMapper.getEmployeerSift();
	}

	public int insertSift(SiftDTO sDTO) {
		return eMapper.insertSift(sDTO);
	}

	public int updateSift(SiftDTO sDTO) {
		return eMapper.updateSift(sDTO);
	}

	public int deleteSift(SiftDTO sDTO) {
		return eMapper.deleteSift(sDTO);
	}
	
}

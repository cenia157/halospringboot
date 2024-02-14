package com.halo.main.admin.manager.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class StaffService {

	@Autowired
	private StaffMapper staffMapper;

	public void goStaff(Model model) {
		model.addAttribute("menuname", "スタッフの管理");
		model.addAttribute("menu", "/WEB-INF/views/admin/manager/staff/staffContent.jsp");
	}
	
	public List<Staff> getAllStaffList(Staff staff) {
		return staffMapper.getAllStaffList(staff);
	}

	public int regStaff(Staff staff) {
		return staffMapper.regStaff(staff);
	}

	public int updateStaff(Staff staff) {
		System.out.println(staffMapper.updateStaff(staff));
		return staffMapper.updateStaff(staff);
		
	}

	public int deleteStaff(Staff staff) {
		return staffMapper.deleteStaff(staff);
	}


	
	
	
}

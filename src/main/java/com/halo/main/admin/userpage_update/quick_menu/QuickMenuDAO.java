package com.halo.main.admin.userpage_update.quick_menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class QuickMenuDAO {
	
	@Autowired
	private QuickMenuMapper qMenuMapper;
	
	public List<QuickMenuDTO> getListQuickMenu(){
		return qMenuMapper.getListQuickMenu();
	}

	public int updateQuickMenu(QuickMenuDTO qmdto, Model model) {
	// 받아온 b_m_name 4,5,6으로 3번 돌리기
		
		
		
		return qMenuMapper.updateQuickMenu(qmdto);
		
	}
	
	
	
}

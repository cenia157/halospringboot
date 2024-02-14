package com.halo.main.admin.userpage_update.quick_menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class QuickMenuDAO {
	
	@Autowired
	private QuickMenuMapper qMenuMapper;
	
	public List<QuickMenuDTO> getListQuickMenu(){
		return qMenuMapper.getListQuickMenu();
	}

	public int updateQuickMenu(
			@RequestParam String b_m_name4,
			@RequestParam String b_m_name5,
			@RequestParam String b_m_name6,
			QuickMenuDTO qmdto, Model model) {
		String[] quickMenuValues = {b_m_name4, b_m_name5, b_m_name6};
		//셀렉에서 받아온 b_m_name4,5,6 3번 돌리기
		for (int i = 0; i < 3; i++) {
			System.out.println("quickMenuValues["+(i+4)+"번]:"+quickMenuValues[i]);
			
		}
		
		
		return qMenuMapper.updateQuickMenu(qmdto);
		
	}
	
	
	
}

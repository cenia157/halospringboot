package com.halo.main.admin.userpage_update.quick_menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class QuickMenuDAO {
	
	@Autowired
	private QuickMenuMapper qMenuMapper;
	
	//상단빠른메뉴 3
	public List<QuickMenuDTO> getListQuickMenu(){
		return qMenuMapper.getListQuickMenu();
	}

	public int updateQuickMenu(QuickMenuDTO qmdto, Model model) {
		
		return qMenuMapper.updateQuickMenu(qmdto);
		
	}
	
	
	
}

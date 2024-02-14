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

	public int updateQuickMenu(@RequestParam("m_name4") String m_name4,
			@RequestParam("m_name5") String m_name5,
			@RequestParam("m_name6") String m_name6,
			 Model model) {
		System.out.println("DAOvalue3개 : "+ m_name4 +", "+ m_name5 +", "+ m_name6);
		String[] quickMenuValues = {m_name4, m_name5, m_name6};
		//셀렉에서 받아온 m_name4,5,6 3번 돌리기
		for (int i = 0; i < 3; i++) {
			if(i == 0) {
				if (qMenuMapper.updateQuickMenu(quickMenuValues[i], 4) == 0) {
					System.out.println("4번 업뎃 실패");
				}
			} else if (i == 2) {
				if (qMenuMapper.updateQuickMenu(quickMenuValues[i], 5) == 0) {
					System.out.println("5번 업뎃 실패");
				}
			} else {
				if (qMenuMapper.updateQuickMenu(quickMenuValues[i], 6) == 0) {
					System.out.println("6번 업뎃 실패");
				}
			}
		}
		return 0;
	}
	
	
	
}

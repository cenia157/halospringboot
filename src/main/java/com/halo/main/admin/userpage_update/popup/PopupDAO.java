package com.halo.main.admin.userpage_update.popup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.main.util.Utils;

@Service
public class PopupDAO {
	
	@Autowired
	private PopupMapper popupMapper;
	
	@Autowired
	private Utils utils;
	
	public PopupDTO getPopupDTO() {
		return popupMapper.getPopupDTO();
	}

	public int updatePopup(String m_name, String p_url, String p_img, PopupDTO pdto) {
		
		// 가져온 url을 사용하는 경우
		if(m_name.equals("url")) {
			if(popupMapper.updatePopup(p_img, p_url) == 1) {
				System.out.println("popup update success : url");
			}
			
		} else {
			if (popupMapper.updatePopupWithMenu(p_img, m_name, pdto) == 1) {
				System.out.println("popup update success : menu");
			} 
		}
		return 0;
	}
	
	
	
}

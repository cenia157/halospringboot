package com.halo.main.admin.userpage_update.popup;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PopupMapper {
	
	@Select("select * from popup_tbl")
	PopupDTO getPopupDTO();

	@Update("update popup_tbl set p_img=#{p_img}, p_url=#{p_url}")
	int updatePopup(PopupDTO pdto);
	
	@Update("update popup_tbl set p_img=#{p_img}, p_url=(select m_servlet from menu_tbl where m_name=#{b_m_name})")
	int updatePopupWithMenu(PopupDTO pdto);
	
	
}

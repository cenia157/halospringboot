package com.halo.main.admin.userpage_update.popup;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PopupMapper {
	
	@Select("select p_img, p_url, p_flag, nvl(m_text,'URL') as m_text from popup_tbl left outer join menu_tbl on m_servlet = p_url")
	PopupDTO getPopupDTO();

	@Update("update popup_tbl set p_img=#{p_img}, p_url=#{p_url}")
	int updatePopup(PopupDTO pdto);
	
	@Update("update popup_tbl set p_img=#{p_img}, p_url=(select m_servlet from menu_tbl where m_name=#{b_m_name})")
	int updatePopupWithMenu(PopupDTO pdto);
	
	@Update("update popup_tbl set p_flag = #{p_flag}")
	int checkPopupOnOff(PopupDTO pdto);
	
}

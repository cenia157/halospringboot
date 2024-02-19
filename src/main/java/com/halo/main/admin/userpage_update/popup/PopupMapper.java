package com.halo.main.admin.userpage_update.popup;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PopupMapper {
	
	@Select("select * from popup_tbl")
	PopupDTO getPopupDTO();

	@Update("update popup_tbl set p_img=#{p_img}, p_url=#{p_url}")
	int updatePopup(@Param("p_img") String p_img, @Param("p_url") String p_url);
	
	@Update("update popup_tbl set p_img=#{p_img}, p_url=(select m_servlet from menu_tbl where m_name=#{m_name})")
	int updatePopupWithMenu(@Param("p_img") String p_img,@Param("m_name") String m_name, PopupDTO pdto);
	
	
}

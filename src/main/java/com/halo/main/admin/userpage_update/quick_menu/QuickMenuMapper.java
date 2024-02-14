package com.halo.main.admin.userpage_update.quick_menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface QuickMenuMapper {
	@Select("select * from banner_tbl, menu_tbl where b_index > 3 and b_m_name = m_name")
	List<QuickMenuDTO> getListQuickMenu();
	
	@Update("update banner_tbl set b_m_name = #{m_name},"
			+ "b_url=(select m_text from menu_tbl where m_name=#{m_name})"
			+ "b_m_text = (select m_text from menu_tbl where m_name=#{m_name})"
			+ "where b_index=#{i}")
	int updateQuickMenu(String m_name, int i);

}

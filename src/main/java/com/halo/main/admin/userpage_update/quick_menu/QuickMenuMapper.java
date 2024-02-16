package com.halo.main.admin.userpage_update.quick_menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface QuickMenuMapper {
	@Select("select * from banner_tbl, menu_tbl where b_index > 3 and b_m_name = m_name")
	List<QuickMenuDTO> getListQuickMenu();
	
	@Update("UPDATE banner_tbl"
			+ " SET b_m_name = #{name},"
			+ " b_url = (SELECT m_text FROM menu_tbl WHERE m_name = #{name}),"
			+ " b_m_text = (SELECT m_text FROM menu_tbl WHERE m_name = #{name})"
			+ "WHERE b_index = #{i}")
	int updateQuickMenu(@Param("name") String name, @Param("i") int i);
	

}

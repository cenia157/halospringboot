package com.halo.main.admin.userpage_update.quick_menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface QuickMenuMapper {
	@Select("select * from banner_tbl, menu_tbl where b_index > 3 and b_m_name = m_name")
	List<QuickMenuDTO> getListQuickMenu();
	
	@Update("")
	int updateQuickMenu(QuickMenuDTO qmdto);

}

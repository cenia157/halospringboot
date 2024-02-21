package com.halo.main.admin.userpage_update.quick_menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import com.halo.main.admin.userpage_update.banner.BannerDTO;
@Mapper
public interface QuickMenuMapper {
	
	
	@Select("select b_index, b_type, b_m_name, b_url, nvl(b_m_text, 'empty') as b_m_text, nvl(b_img_url, 'empty') as b_img_url from banner_tbl where b_index > 3 order by b_index")
	List<BannerDTO> getListQuickMenu();
	
	@Update("UPDATE banner_tbl"
			+ " SET b_m_name = #{name},"
			+ " b_url = (SELECT m_servlet FROM menu_tbl WHERE m_name = #{name}),"
			+ " b_m_text = (SELECT m_text FROM menu_tbl WHERE m_name = #{name})"
			+ "WHERE b_index = #{i}")
	int updateQuickMenu(@Param("name") String name, @Param("i") int i);
	

}

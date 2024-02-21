package com.halo.main.admin.userpage_update.banner;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BannerMapper {
	
	@Select("select b_index, b_type, b_m_name, b_url, nvl(b_m_text, 'empty') as b_m_text, nvl(b_img_url, 'empty') as b_img_url from banner_tbl where b_index < 4 order by b_index")
	List<BannerDTO> getBottomBanner();
	
	@Update("update banner_tbl set b_type = 2, b_m_name = #{b_m_name}, b_url = #{b_url}, b_m_text = #{b_m_text}, b_img_url = #{b_img_url} \r\n"
			+ "where b_index = #{b_index}")
	void updateBannerSales(BannerDTO bdto);
	
	@Update("update banner_tbl set b_type = 1, b_m_name = #{b_m_name}, \r\n"
			+ "b_url = (select m_servlet from menu_tbl \r\n"
			+ "where m_name = #{b_m_name}), \r\n"
			+ "b_m_text = (select m_text from menu_tbl \r\n"
			+ "where m_name = #{b_m_name}) \r\n"
			+ "where b_index = #{b_index}")
	void updateBannerMenu(BannerDTO bdto);

}

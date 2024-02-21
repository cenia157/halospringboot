package com.halo.main.admin.userpage_update.logo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LogoMapper {
	@Select("select h_logo_img from homepage_common")
	LogoDTO getLogoDTO();
	
	@Update("update homepage_common set h_logo_img = #{h_logo_img}")
	int updateLogo(LogoDTO ldto);
	
	
}

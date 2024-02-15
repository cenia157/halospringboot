package com.halo.main.admin.userpage_update.logo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogoMapper {

	LogoDTO getLogoDTO();
	
	
}

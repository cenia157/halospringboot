package com.halo.main.admin.userpage_update.logo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogoDAO {
	
	@Autowired
	private LogoMapper logoMapper;
	
	public LogoDTO getLogoDTO() {
		return logoMapper.getLogoDTO();
	}
}

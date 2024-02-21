package com.halo.main.user.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.main.admin.userpage_update.banner.BannerMapper;
import com.halo.main.admin.userpage_update.information.AdminInformationMapper;
import com.halo.main.admin.userpage_update.quick_menu.QuickMenuMapper;

@Service
public class HomepageDAO {
	
	@Autowired
	private BannerMapper bottomMapper;
	
	@Autowired
	private QuickMenuMapper topMapper;
	
	@Autowired
	private AdminInformationMapper homeMapper;
	
	public HomepageCommonDTO getAllhomepage() {
		HomepageCommonDTO hdto = homeMapper.getListInfo();
		hdto.setBottomBanners(bottomMapper.getBottomBanner());
		hdto.setTopBanners(topMapper.getListQuickMenu());
		System.out.println(hdto.getBottomBanners());
		System.out.println(hdto.getTopBanners());
		
		
		return hdto;
	}
	
	
	
}

package com.halo.main.admin.userpage_update.information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.main.user.common.HomepageCommonDTO;

@Service
public class AdminInformationDAO {
	
	@Autowired
	private AdminInformationMapper aInfoMapper;
	
	public HomepageCommonDTO getListInfo() {
		return aInfoMapper.getListInfo();
	}
	
	public int updateInfo(HomepageCommonDTO hdto) {
		return aInfoMapper.updateInfo(hdto);
	}

}

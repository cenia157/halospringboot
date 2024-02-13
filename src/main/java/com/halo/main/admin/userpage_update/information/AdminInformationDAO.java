package com.halo.main.admin.userpage_update.information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.main.user.common.HompageCommonDTO;

@Service
public class AdminInformationDAO {
	
	@Autowired
	private AdminInformationMapper aInfoMapper;
	
	public int updateInfo(HompageCommonDTO hdto) {
		return aInfoMapper.updateInfo(hdto);
	}
}

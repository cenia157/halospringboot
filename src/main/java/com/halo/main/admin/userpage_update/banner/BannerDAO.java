package com.halo.main.admin.userpage_update.banner;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BannerDAO {
	
	@Autowired
	private BannerMapper bannerMapper;
	
	public ResponseEntity<?> updateBanner(List<BannerDTO> bdtoList) {
		String isSuccess = "false";
		for(BannerDTO bdto : bdtoList) {
				if(bdto.getB_m_name().equals("sales")) {
					bdto.setB_type(2);
					bannerMapper.updateBannerSales(bdto);
					isSuccess = "true";
				} else {
					bdto.setB_type(1);
					bannerMapper.updateBannerMenu(bdto);
					isSuccess = "true";
					
				}
			}
		JSONObject jo = new JSONObject();
		jo.put("isSuccess", isSuccess);
		return ResponseEntity.ok(jo.toJSONString());
	}

}

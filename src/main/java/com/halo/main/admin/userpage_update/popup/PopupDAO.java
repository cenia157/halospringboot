package com.halo.main.admin.userpage_update.popup;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.halo.main.util.Utils;

@Service
public class PopupDAO {
	
	@Autowired
	private PopupMapper popupMapper;
	
	@Autowired
	private Utils utils;
	
	public PopupDTO getPopupDTO() {
		return popupMapper.getPopupDTO();
	}

	public ResponseEntity<?> updatePopup(PopupDTO pdto) {
		String isSuccess = "false";
		// 가져온 url을 사용하는 경우
	    if ("url".equals(pdto.getB_m_name())) {
	        if (popupMapper.updatePopup(pdto) == 1) {
	            System.out.println("popup update success : url");
	            isSuccess = "true"; // 성공 시 1 반환
	        }
	    } else {
	        if (popupMapper.updatePopupWithMenu(pdto) == 1) {
	            System.out.println("popup update success : menu");
	            isSuccess = "true"; // 성공 시 1 반환
	        }
	    }
	    
	    
	    
	    JSONObject jo = new JSONObject();
		jo.put("isSuccess", isSuccess);
		return ResponseEntity.ok(jo.toJSONString()); // 실패 시 0 반환
	}

	
	public ResponseEntity<?> checkPopupOnOff(PopupDTO pdto) {
			String popupStatus = "off";
			if(pdto.getP_flag() == 1)
				popupStatus = "on";
			String isSuccess = "Popup : " + popupStatus + " fail!";
		
			if (popupMapper.checkPopupOnOff(pdto) == 1) {
				isSuccess = "Popup : " + popupStatus + " success!";
			}
			
			System.out.println(isSuccess);
			
		JSONObject jo = new JSONObject();
		jo.put("popupOnOffStatus", isSuccess);
		return ResponseEntity.ok(jo.toJSONString());
	}
	
	
	
}

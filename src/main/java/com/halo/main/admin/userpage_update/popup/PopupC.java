package com.halo.main.admin.userpage_update.popup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.halo.main.util.Utils;

@Controller
@RequestMapping("/admin/homepage-update")
public class PopupC {
	
	@Autowired
	private Utils utils;
	@Autowired
	private PopupDAO popupDao;
	
	@GetMapping("/popup")
	public String goPopup(Model model) {
		model.addAttribute("menuname","ポップアップの設定");
		model.addAttribute("menu", "/WEB-INF/views/admin/popup/popupContent.jsp");
		model.addAttribute("pdto", popupDao.getPopupDTO());
		System.out.println(popupDao.getPopupDTO());
		return "/admin/index";
	}
	
	@PostMapping("/popup/upload-file")
	public ResponseEntity<?> uploadPopupFile(@RequestParam("popup_img") MultipartFile file) {
		//비동기(업뎃예정 img 미리보기)
		return utils.uploadFile(file,"popup",1);
	}
	
	@PostMapping("/popup/update")
	public ResponseEntity<?> updatePopup(
			@RequestBody PopupDTO pdto) {
	    return popupDao.updatePopup(pdto);
	}

	
	
	
}

package com.halo.main.admin.userpage_update.logo;

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
public class LogoC {
	
	@Autowired
	private LogoDAO logoDao;
	@Autowired
	private Utils utils;
	
	@GetMapping("/logo")
	public String goLogo(Model model) {
		
		model.addAttribute("menuname","ロゴ変更");
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/logo/logoContent.jsp");
		//기존 이미지(DB)어트리뷰트 세팅
		model.addAttribute("hdto", logoDao.getLogoDTO());
		return "/admin/index";
	}
	
	@PostMapping("/logo/upload-file")
	public ResponseEntity<?> uploadLogoFile(@RequestParam("logo_img") MultipartFile file) {
		//비동기(업뎃예정 img 미리보기)
		return utils.uploadFile(file,"logo",1);
	}
	
	@PostMapping("/logo/update")
	public ResponseEntity<?> updateLogo(@RequestBody LogoDTO ldto) {
		//업데이트(실제 DB에 업뎃)
		return logoDao.updateLogo(ldto);
	}
	
}

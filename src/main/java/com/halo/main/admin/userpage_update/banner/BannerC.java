package com.halo.main.admin.userpage_update.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.halo.main.util.Utils;

@Controller
@RequestMapping("/admin/homepage-update")
public class BannerC {

	@Autowired
	private Utils utils;
	@Autowired
	private BannerDAO bannerDao;

	@GetMapping("/banner")
	public String goBanner(Model model) {

		model.addAttribute("menuname", "下のバナー設定");
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/banner/bannerContent.jsp");

		return "/admin/index";
	}

	@PostMapping("/banner/banner-upload-file")
	public ResponseEntity<?> uploadLogoFile(@RequestParam("logo_img") MultipartFile file) {
		// 비동기(업뎃예정 img 미리보기)
		return utils.uploadFile(file, "logo", 1);
	}

}

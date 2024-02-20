package com.halo.main.user.common;

import java.util.List;

import com.halo.main.admin.userpage_update.banner.BannerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor	//기본생성자
@AllArgsConstructor	//오버로딩생성자
@Data				//getter,setter
public class HomepageCommonDTO {
	private int h_seq;					//시퀀스_번호
	private String h_logo_img;			//로고 이미지
	private String h_slogan;			//슬로건
	private String h_left_banner_title;	//하단베너 왼쪽 제목
	private String h_center_banner_title;//하단베너 중앙 제목
	private String h_right_banner_title;//하단베너 오른쪽 제목
	private String h_left_banner_img;	//하단베너 왼쪽 이미지
	private String h_center_banner_img;	//하단베너 중앙 이미지
	private String h_right_banner_img;	//하단베너 오른쪽 이미지
	private String h_tel_no;			//footer 전화번호
	private String h_fax_no;			//footer 팩스번호
	private String h_phone_no;			//footer 핸드폰번호
	private String h_email;				//footer 이메일
	private String h_address;			//footer (회사)주소
	private String h_resume_file;		//이력서
	private List<BannerDTO> bottomBanners;
	private List<BannerDTO> topBanners;	
	private String p_img;		//팝업 이미지, url, flag -> on/off
	private String p_url;
	private int p_flag;
	
	
	
	
}

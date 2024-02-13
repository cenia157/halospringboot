package com.halo.main.user.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor	//기본생성자
@AllArgsConstructor	//오버로딩생성자
@Data				//getter,setter
public class HompageCommonDTO {
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
	private int h_b_type1;				//type -> 빠른메뉴 or 상품판매
	private String h_m_name1;			// 여기서부터 123-> 하단베너
	private String h_b_url1;
	private String h_b_m_text1;
	private String h_b_img_url1;
	private int h_b_type2;
	private String h_m_name2;
	private String h_b_url2;
	private String h_b_m_text2;
	private String h_b_img_url2;
	private int h_b_type3;
	private String h_m_name3;
	private String h_b_url3;
	private String h_b_m_text3;
	private String h_b_img_url3;
	private int h_b_type4;				// 456 -> 빠른메뉴(메인 홈 상단)
	private String h_m_name4;		
	private String h_b_url4;
	private String h_b_m_text4;
	private String h_b_img_url4;
	private int h_b_type5;
	private String h_m_name5;
	private String h_b_url5;
	private String h_b_m_text5;
	private String h_b_img_url5;
	private int h_b_type6;
	private String h_m_name6;
	private String h_b_url6;
	private String h_b_m_text6;
	private String h_b_img_url6;
	private String p_img;		//팝업 이미지, url, flag -> on/off
	private String p_url;
	private int p_flag;
	
	
	
	
}

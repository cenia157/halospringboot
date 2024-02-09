package com.halo.main;

public class HomepageDTO {
	int h_seq;					//시퀀스_번호
	String h_logo_img;			//로고 이미지
	String h_slogan;			//슬로건
	String h_left_banner_title;	//하단베너 왼쪽 제목
	String h_center_banner_title;//하단베너 중앙 제목
	String h_right_banner_title;//하단베너 오른쪽 제목
	String h_left_banner_img;	//하단베너 왼쪽 이미지
	String h_center_banner_img;	//하단베너 중앙 이미지
	String h_right_banner_img;	//하단베너 오른쪽 이미지
	String h_tel_no;			//footer 전화번호
	String h_fax_no;			//footer 팩스번호
	String h_phone_no;			//footer 핸드폰번호
	String h_email;				//footer 이메일
	String h_address;			//footer (회사)주소
	String h_resume_file;		//이력서 파일 양식
	// 네이밍 최적화 예시 => logo, BannerTitle
	
	//필수3
	public HomepageDTO() {

	}

	public HomepageDTO(int h_seq, String h_logo_img, String h_slogan, String h_left_banner_title,
			String h_center_banner_title, String h_right_banner_title, String h_left_banner_img,
			String h_center_banner_img, String h_right_banner_img, String h_tel_no, String h_fax_no, String h_phone_no,
			String h_email, String h_address, String h_resume_file) {
		super();
		this.h_seq = h_seq;
		this.h_logo_img = h_logo_img;
		this.h_slogan = h_slogan;
		this.h_left_banner_title = h_left_banner_title;
		this.h_center_banner_title = h_center_banner_title;
		this.h_right_banner_title = h_right_banner_title;
		this.h_left_banner_img = h_left_banner_img;
		this.h_center_banner_img = h_center_banner_img;
		this.h_right_banner_img = h_right_banner_img;
		this.h_tel_no = h_tel_no;
		this.h_fax_no = h_fax_no;
		this.h_phone_no = h_phone_no;
		this.h_email = h_email;
		this.h_address = h_address;
		this.h_resume_file = h_resume_file;
	}

	public int getH_seq() {
		return h_seq;
	}

	public void setH_seq(int h_seq) {
		this.h_seq = h_seq;
	}

	public String getH_logo_img() {
		return h_logo_img;
	}

	public void setH_logo_img(String h_logo_img) {
		this.h_logo_img = h_logo_img;
	}

	public String getH_slogan() {
		return h_slogan;
	}

	public void setH_slogan(String h_slogan) {
		this.h_slogan = h_slogan;
	}

	public String getH_left_banner_title() {
		return h_left_banner_title;
	}

	public void setH_left_banner_title(String h_left_banner_title) {
		this.h_left_banner_title = h_left_banner_title;
	}

	public String getH_center_banner_title() {
		return h_center_banner_title;
	}

	public void setH_center_banner_title(String h_center_banner_title) {
		this.h_center_banner_title = h_center_banner_title;
	}

	public String getH_right_banner_title() {
		return h_right_banner_title;
	}

	public void setH_right_banner_title(String h_right_banner_title) {
		this.h_right_banner_title = h_right_banner_title;
	}

	public String getH_left_banner_img() {
		return h_left_banner_img;
	}

	public void setH_left_banner_img(String h_left_banner_img) {
		this.h_left_banner_img = h_left_banner_img;
	}

	public String getH_center_banner_img() {
		return h_center_banner_img;
	}

	public void setH_center_banner_img(String h_center_banner_img) {
		this.h_center_banner_img = h_center_banner_img;
	}

	public String getH_right_banner_img() {
		return h_right_banner_img;
	}

	public void setH_right_banner_img(String h_right_banner_img) {
		this.h_right_banner_img = h_right_banner_img;
	}

	public String getH_tel_no() {
		return h_tel_no;
	}

	public void setH_tel_no(String h_tel_no) {
		this.h_tel_no = h_tel_no;
	}

	public String getH_fax_no() {
		return h_fax_no;
	}

	public void setH_fax_no(String h_fax_no) {
		this.h_fax_no = h_fax_no;
	}

	public String getH_phone_no() {
		return h_phone_no;
	}

	public void setH_phone_no(String h_phone_no) {
		this.h_phone_no = h_phone_no;
	}

	public String getH_email() {
		return h_email;
	}

	public void setH_email(String h_email) {
		this.h_email = h_email;
	}

	public String getH_address() {
		return h_address;
	}

	public void setH_address(String h_address) {
		this.h_address = h_address;
	}

	public String getH_resume_file() {
		return h_resume_file;
	}

	public void setH_resume_file(String h_resume_file) {
		this.h_resume_file = h_resume_file;
	}
	
	
	
	
}

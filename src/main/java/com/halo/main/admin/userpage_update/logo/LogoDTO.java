package com.halo.main.admin.userpage_update.logo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogoDTO {
	private String h_logo_img;	//이미지 파일 이름 varchar
	private int h_seq;			//1 고정
}

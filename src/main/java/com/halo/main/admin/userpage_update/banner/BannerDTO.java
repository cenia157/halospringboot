package com.halo.main.admin.userpage_update.banner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BannerDTO {
	private int b_index; 		// 몇번째박스인지 1~3
	private int b_type; 		// sales 인지 아닌지
	private String b_m_name; 	// select option value
	private String b_url;		// 연결될 메뉴url
	private String b_m_text;	// 메뉴이름 or 상품이름
	private String b_img_url;	// 상품일때 url
	private String m_name;	// 
	
}

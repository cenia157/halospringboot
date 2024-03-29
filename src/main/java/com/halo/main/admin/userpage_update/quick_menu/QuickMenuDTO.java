package com.halo.main.admin.userpage_update.quick_menu;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuickMenuDTO {
	//menu_tbl -> input name, 해당 메뉴 url(서블렛), 메뉴이름 출력txt
	private String m_name;
	private String m_servlet; 
	private String m_text;
	//banner_tbl join함
	private int b_index; 		//456
	private int b_type;
	private String b_m_name; 	//value
	private String b_url;		//클릭시 이동할 url
	private String b_m_text; 	//메뉴 이름
	
}

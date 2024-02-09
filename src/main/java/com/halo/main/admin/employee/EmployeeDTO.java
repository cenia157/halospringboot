package com.halo.main.admin.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
	
	private int s_no;
	private String s_position;
	private String s_name;
	private String s_phone_num;
	private String s_entry_date;
	private String s_color;
	private String s_addr;
	
}

package com.halo.main.admin.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor //기본생성자
@AllArgsConstructor //오버로딩생성자
@Data //게터세터
public class CompanyScheduleDTO {
	private String cs_year;
	private String cs_month;
	private String cs_title;
	private String cs_txt;
	private String cs_date;
	private String cs_update;
	private String cs_no;

}

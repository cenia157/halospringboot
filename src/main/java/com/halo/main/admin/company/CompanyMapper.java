package com.halo.main.admin.company;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CompanyMapper {
	
	@Select("select * from company_schedule")
	List<CompanyScheduleDTO> getCompanyScheduleList();
	
	@Insert("insert into company_schedule values(company_schedule_seq.nextval, #{cs_year}, #{cs_month}, #{cs_title}, #{cs_txt}, #{cs_date}, #{cs_update})")
	int insertCompanySchedule(CompanyScheduleDTO csDTO);
	
	@Update("Update company_schedule set cs_txt = #{cs_txt} where cs_no = #{cs_no}")
	int updateTxtCompanySchedule(CompanyScheduleDTO csDTO);
	
	@Update("Update company_schedule set cs_date = #{cs_date} where cs_no = #{cs_no}")
	int deleteCompanySchedule(CompanyScheduleDTO csDTO);
	
	@Delete("delete from company_schedule where cs_no = #{cs_no}")
	int deleteRowCompanySchedule(CompanyScheduleDTO csDTO);

	
}

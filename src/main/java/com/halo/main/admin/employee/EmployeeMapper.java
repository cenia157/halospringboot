package com.halo.main.admin.employee;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {
	
	@Select("SELECT s_no, s_position, s_name, s_phone_num, TO_CHAR(s_entry_date, 'YYYY-MM-DD') as s_entry_date, s_color, s_addr FROM staff_info order by s_entry_date desc")
	List<EmployeeDTO> getEmployeerList();
	
	@Select("SELECT * from staff_sift")
	List<SiftDTO> getEmployeerSift();
	
	@Insert("INSERT INTO staff_sift VALUES (staff_sift_seq.nextval, #{f_year}, #{f_month}, #{f_dates}, #{f_staffNo})")
	int insertSift(SiftDTO sDTO);
	
	@Update("Update staff_sift set f_dates = #{f_dates} where f_no = #{f_no}")
	int updateSift(SiftDTO sDTO);
	
	@Delete("delete staff_sift where f_no = #{f_no}")
	int deleteSift(SiftDTO sDTO);
	
}

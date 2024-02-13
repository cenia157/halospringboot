package com.halo.main.admin.manager.staff;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StaffMapper {

	@Select("SELECT s_no, s_position, s_name, s_phone_num, TO_CHAR(s_entry_date, 'YYYY-MM-DD') as s_entry_date, s_color, s_addr FROM staff_info order by s_entry_date desc, s_no desc")
	List<Staff> getAllStaffList(Staff staff);

	@Insert("insert into staff_info values(staff_info_seq.nextval, #{s_position}, #{s_name}, #{s_phone_num}, TO_DATE(#{s_entry_date}, 'YYYY-MM-DD'), #{s_color}, #{s_addr})")
	int regStaff(Staff staff);

	@Update("UPDATE staff_info SET s_position = #{s_position}, s_name = #{s_name}, s_phone_num = #{s_phone_num}, s_entry_date = TO_DATE(#{s_entry_date}, 'YYYY-MM-DD'), s_color = #{s_color}, s_addr = #{s_addr} WHERE s_no = #{s_no}")
	int updateStaff(Staff staff);
}

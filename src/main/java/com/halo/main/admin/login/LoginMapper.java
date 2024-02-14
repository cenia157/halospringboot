package com.halo.main.admin.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

	@Select("select * from admin_acount where a_id= #{a_id}")
	AdminAccount login(String a_id); 

	
	
}

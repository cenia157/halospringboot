package com.halo.main.admin.userpage_update.information;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.halo.main.user.common.HompageCommonDTO;

@Mapper
public interface AdminInformationMapper {
	
	@Update("update homepage_common set h_tel_no=#{h_tel_no}, h_fax_no=#{h_fax_no}, h_phone_no=#{h_phone_no}, h_email=#{h_email}, h_address=#{h_address} where h_seq=1")
	int updateInfo(HompageCommonDTO hdto);
	
}

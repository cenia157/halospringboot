package com.halo.main.admin.userpage_update.information;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.halo.main.user.common.HomepageCommonDTO;

@Mapper
public interface AdminInformationMapper {
	
	@Select("select * from homepage_common")
	List<HomepageCommonDTO> getListInfo();

	@Update("update homepage_common set h_tel_no=#{h_tel_no}, h_fax_no=#{h_fax_no}, h_phone_no=#{h_phone_no}, h_email=#{h_email}, h_address=#{h_address} where h_seq=1")
	int updateInfo(HomepageCommonDTO hdto);
	
}

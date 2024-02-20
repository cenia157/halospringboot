package com.halo.main.user.common;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HomepageMapper {
	@Select("select * from homepage_common")
	HomepageCommonDTO getAllhomepage(HomepageCommonDTO hdto);

}

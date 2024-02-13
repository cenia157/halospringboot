package com.halo.main.user.introduce.announcement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnnouncedMapper {

	@Select("SELECT * FROM announced_tbl ORDER BY an_seq ASC")
	List<AnnouncedDTO> getAllAnnouncements();

	@Select("SELECT * FROM announced_tbl WHERE an_seq = #{anSeq}")
	AnnouncedDTO getAnnouncement(int anSeq);

}

package com.halo.main.admin.boardmanagement.notice;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NoticeMapper {

	@Select({ "<script>", "SELECT * FROM ANNOUNCED_TBL WHERE an_category IN",
			"<foreach item='category' collection='categories' separator=',' open='(' close=')'>", "#{category}",
			"</foreach>", "ORDER BY an_seq ASC", "</script>" })
	List<NoticeDTO> getAllNotice(@Param("categories") List<String> categories);

	@Select("SELECT * FROM ANNOUNCED_TBL WHERE an_seq = #{an_Seq}")
	List<NoticeDTO> getNoticeDetail(int an_seq);

	@Insert("INSERT INTO ANNOUNCED_TBL VALUES (announced_tbl_seq.nextval, #{title}, #{txt}, #{writer},sysdate, #{select})")
	int regNotice(@Param("writer") String writer, @Param("title") String title, @Param("select") String select, @Param("txt") String txt);

}

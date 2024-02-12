package com.halo.main.admin.boardmanagement.notice;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NoticeMapper {

	@Select({ "<script>", "SELECT * FROM ANNOUNCED_TBL WHERE an_category IN",
			"<foreach item='category' collection='categories' separator=',' open='(' close=')'>", "#{category}",
			"</foreach>", "ORDER BY an_seq ASC", "</script>" })
	List<NoticeDTO> getAllNotice(@Param("categories") List<String> categories);

	@Select("SELECT * FROM ANNOUNCED_TBL WHERE an_seq = #{an_Seq}")
	List<NoticeDTO> getNoticeDetail(int an_seq);

	@Insert("INSERT INTO ANNOUNCED_TBL VALUES (announced_tbl_seq.nextval, #{title}, #{txt}, #{writer}, CURRENT_TIMESTAMP, #{select})")
	int regNotice(@Param("writer") String writer, @Param("title") String title, @Param("select") String select, @Param("txt") String txt);

	@Delete("Delete ANNOUNCED_TBL WHERE AN_SEQ = #{an_seq}")
	int deleteNotice(int an_seq);

	@Update("UPDATE announced_tbl SET an_title = #{title}, an_content = #{txt}, an_category = #{select} WHERE an_seq = #{seq}")
	int updateNotice(@Param("title") String title, @Param("select") String select, @Param("txt") String txt, @Param("seq") String seq);

}

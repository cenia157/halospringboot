package com.halo.main.user.question;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionMapper {

	@Select("SELECT q.*, c.* "
			+ "FROM question_tbl q "
			+ "LEFT JOIN comment_tbl "
			+ "c ON q.q_seq = c.q_seq "
			+ "ORDER BY q.q_reg_date "
			+ "DESC")
	List<QuestionNCommentsVO> getAllQnCs();

	@Select("SELECT q.*, c.* "
			+ "FROM question_tbl q "
			+ "LEFT JOIN comment_tbl "
			+ "c ON q.q_seq = c.q_seq "
			+ " WHERE q.q_seq = #{q_seq} "
			+ "ORDER BY q.q_reg_date "
			+ "DESC")
	QuestionNCommentsVO getQnC(int q_seq);

	@Insert("insert into question_tbl values"
			+ " (question_tbl_seq.nextval,"
			+ " #{q_title}, #{q_content}, sysdate,"
			+ " #{q_contact_number}, #{q_email},"
			+ " #{q_name}, #{q_password}, #{q_category})")
	int insertquestion(QuestionVO questionVO);

	@Delete("delete from comment_tbl where q_seq=#{q_seq}")
	int deletecomment(int q_seq);
	
	@Delete("delete from question_tbl where q_seq=#{q_seq}")
	int deletequestion(int q_seq);

}

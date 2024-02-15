package com.halo.main.admin.boardmanagement.Question;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionAdminMapper {

	@Select("SELECT q.*, c.*"
			+ " FROM question_tbl q"
			+ " LEFT JOIN comment_tbl c"
			+ " ON q.q_seq = c.q_seq"
			+ " ORDER BY q.q_reg_date")
	List<QuestionAdminVO> getCheckboxedQuestions();

	//우선 전체 데이터 가져오기
	@Select("SELECT q.*, c.*"
			+ " FROM question_tbl q"
			+ " LEFT JOIN comment_tbl c"
			+ " ON q.q_seq = c.q_seq"
			+ " ORDER BY q.q_reg_date")
	List<QuestionAdminVO> getAllQnCs();



}

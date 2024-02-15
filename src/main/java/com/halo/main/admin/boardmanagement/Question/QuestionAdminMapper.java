package com.halo.main.admin.boardmanagement.Question;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionAdminMapper {

	@Select("SELECT q.*, c.*"
			+ " FROM question_tbl q"
			+ " LEFT JOIN comment_tbl c"
			+ " ON q.q_seq = c.q_seq"
			+ " ORDER BY q.q_reg_date")
	List<QuestionAdminVO> getCheckboxedQuestions();

//	//우선 전체 데이터 가져오기
//	@Select("SELECT q.*, c.*"
//			+ " FROM question_tbl q"
//			+ " LEFT JOIN comment_tbl c"
//			+ " ON q.q_seq = c.q_seq"
//			+ " ORDER BY q.q_reg_date")
//	List<QuestionAdminVO> getAllQnCs();

	//우선 전체 데이터 가져오기
//	@Select({
//		"<script>",
//	        "SELECT q.*, c.* "
//	        + "FROM question_tbl q "
//	        + "LEFT JOIN comment_tbl c ON q.q_seq = c.q_seq",
//	        "<where>",
//	        "<choose>",	        	
//		        "<when test='selectedCategories = [completed, uncompleted]'>",
//		        "AND 1 = 1",
//		        "</when>",
//	        	"<when test='selectedCategories = [completed]'>",
//	        	"AND c.c_answer = 1",
//	        	"</when>",
//	        	"<when test='selectedCategories = [uncompleted]'>",
//	        	"AND c.c_answer IS NULL",
//	        	"</when>",
//	        "</choose>",
//	        "</where>",
//	        "</script>"
//        })
//	List<QuestionAdminVO> getAllQnCs(@Param("selectedCategories") List<String> selectedCategories);

	@Select({
	    "<script>",
	    "SELECT q.*, c.* ",
	    "FROM question_tbl q ",
	    "LEFT JOIN comment_tbl c ON q.q_seq = c.q_seq",
	    "<where>",
	    "<choose>",	        	
	        "<when test='selectedCategories != null and !selectedCategories.isEmpty()'>",
	            "AND (",
	            "<foreach item='category' collection='selectedCategories' separator=' OR '>",
	                "<if test='category == \"completed\"'>",
	                    "c.c_answer = 1",
	                "</if>",
	                "<if test='category == \"uncompleted\"'>",
	                    "c.c_answer IS NULL",
	                "</if>",
	            "</foreach>",
	            ")",
	        "</when>",
	        "<otherwise>",
	            "AND 1 = 1",
	        "</otherwise>",
	    "</choose>",
	    "</where>",
	    " ORDER BY q.q_reg_date",
	    "</script>"
	})
	List<QuestionAdminVO> getAllQnCs(@Param("selectedCategories") List<String> selectedCategories);


}

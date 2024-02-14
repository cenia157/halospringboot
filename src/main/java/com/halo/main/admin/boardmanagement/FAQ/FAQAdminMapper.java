package com.halo.main.admin.boardmanagement.FAQ;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.halo.main.user.faq.FAQVO;

@Mapper
public interface FAQAdminMapper {

	@Select("select * from QA_tbl")
	List<FAQVO> getAllFAQsAdmin();

	@Select("select * from QA_tbl where qa_seq=#{qa_seq}")
	FAQVO getFAQDetail(int qa_seq);

	@Select("select * from QA_tbl where qa_seq=#{qa_seq}")
	List<FAQVO> getFAQListAdmin(int qa_seq);

	@Update("update QA_tbl set qa_title=#{qa_title},qa_content=#{qa_content},qa_reg_date=sysdate "
			+ "where qa_seq=#{qa_seq}")
	int updateFAQListAdmin(int qa_seq, String qa_title, String qa_content);

}

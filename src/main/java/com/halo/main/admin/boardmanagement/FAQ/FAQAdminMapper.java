package com.halo.main.admin.boardmanagement.FAQ;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.halo.main.user.faq.FAQVO;

@Mapper
public interface FAQAdminMapper {

	@Select("select * from QA_tbl")
	List<FAQVO> getAllFAQsAdmin();

	@Select("select * from QA_tbl where qa_seq=#{qa_seq}")
	FAQVO getFAQDetail(int qa_seq);

}

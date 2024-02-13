package com.halo.main.user.faq;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FAQMapper {

	@Select("select * from QA_tbl")
	List<FAQVO> getAllFAQ();

	@Select("select * from QA_tbl where qa_seq=#{qa_seq}")
	String getFAQDetail(int qa_seq);

}

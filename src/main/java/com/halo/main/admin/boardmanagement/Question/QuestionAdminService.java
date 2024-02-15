package com.halo.main.admin.boardmanagement.Question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.halo.main.admin.boardmanagement.notice.NoticeDTO;

@Service
public class QuestionAdminService {

	@Autowired
	private QuestionAdminMapper qaMapper;
	private static ArrayList<QuestionAdminVO> QnCs;
	
	public List<QuestionAdminVO> getCheckboxedQuestions() {
		return qaMapper.getCheckboxedQuestions();
	}

	public List<QuestionAdminVO> getAllQnCs() {
		QnCs = (ArrayList<QuestionAdminVO>) qaMapper.getAllQnCs();
		return QnCs;
	}

	public void qaPaging(int page, Model model) {

		int cnt = 8;
		int total = QnCs.size();
		int pageCount = (int) Math.ceil((double) total / cnt);
		if (pageCount < page) {
			page = pageCount;
		}

		model.addAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<QuestionAdminVO> items = new ArrayList<QuestionAdminVO>();
		if (QnCs.size() != 0) {
			for (int i = start - 1; i > end; i--) {
				items.add(QnCs.get(i));
			}
		}
		model.addAttribute("curPageNo", page);
		model.addAttribute("QnCs", items);
		
	}

	
}

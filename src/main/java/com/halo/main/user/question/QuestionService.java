package com.halo.main.user.question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.halo.main.user.introduce.announcement.AnnouncedDTO;

@Service
public class QuestionService {

	@Autowired
	QuestionMapper questionmapper;
	private static ArrayList<QuestionNCommentsVO> QnCs;

	public List<QuestionNCommentsVO> getAllQnCs() {
		return questionmapper.getAllQnCs();
	}

	public QuestionNCommentsVO getQnC(int q_seq) {
		return questionmapper.getQnC(q_seq);
	}

	public int insertquestion(QuestionVO questionVO) {
		return questionmapper.insertquestion(questionVO);
	}

	public int deletequestion(int q_seq) {
		return questionmapper.deletequestion(q_seq);
	}

	public int deletecomment(int q_seq) {
		return questionmapper.deletecomment(q_seq);
	}
	
	// 전체조회
	public List<QuestionNCommentsVO> getAllQnCPaging() {

		QnCs = (ArrayList<QuestionNCommentsVO>) questionmapper.getAllQnCs();

		return QnCs;
	}
	
	// 조회 시, 페이징처리
	public void questionPaging(int page, Model model) {

		model.addAttribute("curPageNo", page);

		int cnt = 5;
		int total = QnCs.size();
		System.out.println("total ::: " + total);
		int pageCount = (int) Math.ceil((double) total / cnt);

		model.addAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<QuestionNCommentsVO> items = new ArrayList<QuestionNCommentsVO>();

		if (total != 0) {
			for (int i = start - 1; i > end; i--) {
				items.add(QnCs.get(i));
			}
		}
		model.addAttribute("QnCs", items);
	}
	
}

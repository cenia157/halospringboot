package com.halo.main.admin.boardmanagement.Question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.halo.main.admin.boardmanagement.notice.NoticeDTO;

@Service
public class QuestionAdminService {

	@Autowired
	private QuestionAdminMapper qaMapper;
	private static ArrayList<QuestionAdminVO> QnCs;
	
	public List<QuestionAdminVO> getCheckboxedQuestions() {
		return qaMapper.getCheckboxedQuestions();
	}

//	public List<QuestionAdminVO> getAllQnCs() {
//		QnCs = (ArrayList<QuestionAdminVO>) qaMapper.getAllQnCs();
//		return QnCs;
//	}
	
	   // 전체조회
	   public List<QuestionAdminVO> getAllQnCs(@RequestParam("checkVal") String checkVal) {
	      String[] checkBoxVal = { "completed", "uncompleted" };
	      List<String> selectedCategories = new ArrayList<>();

	      for (int i = 0; i < checkVal.length(); i++) {
	         int index = Character.getNumericValue(checkVal.charAt(i));
	         selectedCategories.add(checkBoxVal[index]);
	      }
	      
	      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	      //둘다 체크하면 [uncompleted, completed]
	      System.out.println(selectedCategories);
	      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	      
	      QnCs = (ArrayList<QuestionAdminVO>) qaMapper.getAllQnCs(selectedCategories);

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

	//comment
	public int adminCommentDelete(String q_seq) {
		return qaMapper.adminCommentDelete(q_seq);
	}
	//question
	public int adminQuestionDelete(String q_seq) {
		return qaMapper.adminQuestionDelete(q_seq);
	}

	
}

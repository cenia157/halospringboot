package com.halo.main.admin.boardmanagement.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper nMapper;
	private static ArrayList<NoticeDTO> notices;

	public List<NoticeDTO> getAllNotice(@RequestParam("checkVal") String checkVal, Model model) {
		String[] checkBoxVal = { "announcement", "schedule", "general", "service", "product" };
		List<String> selectedCategories = new ArrayList<>();

		for (int i = 0; i < checkVal.length(); i++) {
			int index = Character.getNumericValue(checkVal.charAt(i));
			selectedCategories.add(checkBoxVal[index]);
		}

		System.out.println("checkVal테스트" + checkVal);
		
		notices = (ArrayList<NoticeDTO>) nMapper.getAllNotice(selectedCategories);
		
		return notices;
	}

	public void noticePaging(int page, Model model) {
		
		int cnt = 8;
		int total = notices.size();
		int pageCount = (int) Math.ceil((double) total / cnt);
		if(pageCount < page ) {
			page = pageCount;
		}
			
		model.addAttribute("pageCount", pageCount);
		
		
		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<NoticeDTO> items = new ArrayList<NoticeDTO>();
		if(notices.size() != 0) {
			for (int i = start - 1; i > end; i--) {
				items.add(notices.get(i));
			}
		}
		model.addAttribute("curPageNo", page);
		model.addAttribute("notices", items);
	}

}

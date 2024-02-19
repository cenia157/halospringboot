package com.halo.main.user.introduce.announcement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.halo.main.admin.boardmanagement.notice.NoticeDTO;

@Service
public class AnnouncedService {

	@Autowired
	private AnnouncedMapper aMapper;
	private static ArrayList<AnnouncedDTO> announcements;

	// 전체조회
	public List<AnnouncedDTO> getAllAnnouncements() {

		announcements = (ArrayList<AnnouncedDTO>) aMapper.getAllAnnouncements();

		return announcements;
	}

	// 메인페이지 3개 게시물 조회
	public List<AnnouncedDTO> getMainPageAnnouncements() {

		announcements = (ArrayList<AnnouncedDTO>) aMapper.getMainPageAnnouncements();

		for (AnnouncedDTO announcedDTO : announcements) {
			String content = announcedDTO.getAn_content();
			// <figure> 태그 제거 로직
			while (content.indexOf("<figure") != -1) {
				content = content
						.replace(content.substring(content.indexOf("<figure"), content.indexOf("</figure>") + 9), "");
			}
			announcedDTO.setAn_content(content);
		}

		return announcements;
	}

	// 조회 시, 페이징처리
	public void announcedPaging(int page, Model model) {

		model.addAttribute("curPageNo", page);

		int cnt = 5;
		int total = announcements.size();
		System.out.println("total ::: " + total);
		int pageCount = (int) Math.ceil((double) total / cnt);

		model.addAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<AnnouncedDTO> items = new ArrayList<AnnouncedDTO>();

		if (total != 0) {
			for (int i = start - 1; i > end; i--) {
				items.add(announcements.get(i));
			}
		}
		model.addAttribute("announcements", items);
	}

	// 상세 조회
	public AnnouncedDTO getAnnouncement(int anSeq) {
		return aMapper.getAnnouncement(anSeq);
	}
}

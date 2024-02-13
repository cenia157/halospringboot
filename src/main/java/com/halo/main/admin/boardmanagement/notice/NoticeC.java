package com.halo.main.admin.boardmanagement.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NoticeC {

	@Autowired
	private NoticeService nService;

	// 전체조회
	@GetMapping("/NoticeMainC")
	public String getAllNotice(@RequestParam("checkVal") String checkVal, Model model) {

		model.addAttribute("notices", nService.getAllNotice(checkVal));

		nService.noticePaging(1, model);

		model.addAttribute("menuname", "お知らせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/notice/noticeContent.jsp");

		return "/admin/index";
	}

	// 페이징처리
	@GetMapping("/NoticePagingC")
	public String getNoticePagingC(@RequestParam(value = "p", required = false, defaultValue = "1") int p,
								   @RequestParam("checkVal") String checkVal, 
								   @RequestParam(value = "seq", required = false) Integer seq, Model model) {

		model.addAttribute("notices", nService.getAllNotice(checkVal));
		nService.noticePaging(p, model);

		model.addAttribute("menuname", "お知らせ");
		if (seq != null) {
			model.addAttribute("seq", seq);
		}
		model.addAttribute("pageNum", p);
		model.addAttribute("menuname", "お知らせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/notice/noticeContent.jsp");

		return "/admin/index";
	}

	// 페이징처리
	@PostMapping("/NoticePagingC")
	public String postNoticePagingC(@RequestParam(value = "p", required = false, defaultValue = "1") int p, Model model) {

		nService.noticePaging(p, model);

		model.addAttribute("menuname", "お知らせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/notice/noticeContent.jsp");

		return "/admin/index";
	}

	// 상세조회
	@ResponseBody
	@PostMapping(value = "/GetNoticeDetailC")
	public List<NoticeDTO> getNoticeDetailC(@RequestParam("an_seq") int an_seq) {
		return nService.getNoticeDetailList(an_seq);
	}

	// 이미지 업로드
	@ResponseBody
	@PostMapping(value = "/halo/CKEditorImgUploadC")
	public ResponseEntity<?> uploadFile(@RequestParam("upload") MultipartFile file) {
		return nService.uploadFile(file);
	}

	// 게시물 등록
	@ResponseBody
	@PostMapping(value = "/CkEditorC")
	public int regNotice(@RequestParam(value = "writer", required = false, defaultValue = "세션없음") String writer,
	                     @RequestParam("title") String title, 
	                     @RequestParam("select") String select, 
	                     @RequestParam("txt") String txt,
	                     @RequestParam(value = "saveFname", required = false) String[] saveFnameValues) {

		return nService.regNotice(writer, title, select, txt, saveFnameValues);
	}
	
	// 게시물 업데이트
	@ResponseBody
	@PutMapping(value = "/UpdateNoticeC")
	public int updateNoticeC(@RequestParam("title") String title, 
							 @RequestParam("select") String select, 
							 @RequestParam("txt") String txt,
							 @RequestParam("seq") String seq,
							 @RequestParam(value = "saveFname", required = false) String[] saveFnameValues){
		
		return nService.updateNotice(title, select, txt, seq, saveFnameValues);
	}
	
	// 게시물 삭제
	@GetMapping("/DeleteNoticeC")
	public String deleteNoticeC(@RequestParam("an_seq") int an_seq, 
							   @RequestParam(value = "p", defaultValue = "1") int p, 
						       @RequestParam("checkVal") String checkVal) {
		System.out.println("an_seq ::: " + an_seq);
		System.out.println("p ::: " + p);
		System.out.println("checkVal ::: " + checkVal);
		
		nService.deleteNotice(an_seq);
		
		return String.format("redirect:/NoticePagingC?p=%s&checkVal=%s", p, checkVal);
	}
	

	
	



}

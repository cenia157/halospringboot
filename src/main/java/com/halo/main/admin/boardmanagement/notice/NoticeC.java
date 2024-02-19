package com.halo.main.admin.boardmanagement.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/boardManagement")
public class NoticeC {

	@Autowired
	private NoticeService nService;

	// 페이징처리
	@GetMapping("/notice/{p}/{checkVal}/{seq}")
	public String getNoticePagingC(@PathVariable("p") int p,
								   @PathVariable("checkVal") String checkVal, 
								   @PathVariable(value = "seq", required = false) Integer seq, Model model) {
		model.addAttribute("checkVal", checkVal);
		model.addAttribute("notices", nService.getAllNotice(checkVal));
		nService.noticePaging(p, model);

		if (seq != 0) {
			model.addAttribute("seq", seq);
		}
		model.addAttribute("pageNum", p);
		model.addAttribute("menuname", "お知らせ");
		model.addAttribute("menu", "/WEB-INF/views/admin/boardmanagement/notice/noticeContent.jsp");

		return "/admin/index";
	}
	
	// 상세조회
	@ResponseBody
	@PostMapping(value = "notice/getNoticeDetail")
	public List<NoticeDTO> getNoticeDetailC(@RequestParam("an_seq") int an_seq) {
		return nService.getNoticeDetailList(an_seq);
	}

	// 이미지 업로드
	@ResponseBody
	@PostMapping(value = "/notice/CKEditorImgUpload")
	public ResponseEntity<?> uploadFile(@RequestParam("upload") MultipartFile file) {
		return nService.uploadFile(file);
	}

	// 게시물 등록
	@ResponseBody
	@PostMapping("/notice/regCkEditorModal")
	public int regNotice(@RequestParam("writer") String writer,
	                     @RequestParam("title") String title, 
	                     @RequestParam("select") String select, 
	                     @RequestParam("txt") String txt,
	                     @RequestParam(value = "saveFname", required = false) String[] saveFnameValues) {

			return nService.regNotice(writer, title, select, txt, saveFnameValues);
	}
	
	// 게시물 업데이트
	@ResponseBody
	@PutMapping("/notice/updateNotice")
	public int updateNoticeC(@RequestParam("title") String title, 
							 @RequestParam("select") String select, 
							 @RequestParam("txt") String txt,
							 @RequestParam("seq") String seq,
							 @RequestParam(value = "saveFname", required = false) String[] saveFnameValues){
		
		return nService.updateNotice(title, select, txt, seq, saveFnameValues);
	}
	
	// 게시물 삭제
	@GetMapping("notice/deleteNotice/{p}/{checkVal}/{an_seq}/{pageNumber}")
	public String deleteNotice(@PathVariable("p") int p,
							   @PathVariable("checkVal") String checkVal, 
			                   @PathVariable(value = "an_seq", required = false) Integer an_seq, 
			                   @PathVariable("pageNumber") int pageNumber,
			                   Model model) {
		
		nService.deleteNotice(an_seq);
		
		if(p != pageNumber) {
			p = pageNumber;
		}
		
		return String.format("redirect:/admin/boardManagement/notice/%d/%s/%d", p, checkVal, 0);
	}
}

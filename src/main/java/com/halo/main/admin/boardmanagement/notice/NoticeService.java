package com.halo.main.admin.boardmanagement.notice;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper nMapper;
	private static ArrayList<NoticeDTO> notices;

	// 전체조회
	public List<NoticeDTO> getAllNotice(@RequestParam("checkVal") String checkVal) {
		String[] checkBoxVal = { "announcement", "schedule", "general", "service", "product" };
		List<String> selectedCategories = new ArrayList<>();

		for (int i = 0; i < checkVal.length(); i++) {
			int index = Character.getNumericValue(checkVal.charAt(i));
			selectedCategories.add(checkBoxVal[index]);
		}
		

		notices = (ArrayList<NoticeDTO>) nMapper.getAllNotice(selectedCategories);

		return notices;
	}

	// 페이징
	public void noticePaging(int page, Model model) {

		int cnt = 8;
		int total = notices.size();
		int pageCount = (int) Math.ceil((double) total / cnt);
		if (pageCount < page) {
			page = pageCount;
		}

		model.addAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<NoticeDTO> items = new ArrayList<NoticeDTO>();
		if (notices.size() != 0) {
			for (int i = start - 1; i > end; i--) {
				items.add(notices.get(i));
			}
		}
		model.addAttribute("curPageNo", page);
		model.addAttribute("notices", items);
	}

	// 상세조회
	public List<NoticeDTO> getNoticeDetailList(int an_seq) {
		return nMapper.getNoticeDetail(an_seq);
	}

	// 이미지 업로드
	public ResponseEntity<?> uploadFile(MultipartFile file) {
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("File is empty");
		}

		try {
			String uploadDir = "src/main/resources/static/admin/boardmanagement/notice/0.img/upload";
			String originalFileName = file.getOriginalFilename(); // 원본 파일 이름
			String fileName = originalFileName;
			java.nio.file.Path path = Paths.get(uploadDir);

			if (!Files.exists(path)) {
				Files.createDirectories(path);
			}

			java.nio.file.Path filePath = path.resolve(fileName);
			int counter = 0; 

			while (Files.exists(filePath)) {
				counter++;
				String fileExtension = "";
				String baseFileName = originalFileName;

				int dotIndex = originalFileName.lastIndexOf(".");
				if (dotIndex != -1) {
					baseFileName = originalFileName.substring(0, dotIndex);
					fileExtension = originalFileName.substring(dotIndex);
				}

				fileName = baseFileName + "(" + counter + ")" + fileExtension;
				filePath = path.resolve(fileName);
			}

			Files.copy(file.getInputStream(), filePath); 

			System.out.println("파일경로 ::: " + filePath.toAbsolutePath().toString());
			System.out.println("파일이름 :::: " + fileName);

			JSONObject jo = new JSONObject();
			jo.put("fName", "/admin/boardmanagement/notice/0.img/upload/" + fileName);

			return ResponseEntity.ok(jo.toJSONString());

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Could not upload the file: " + e.getMessage());
		}
	}

	// 게시물 등록
	public int regNotice(String writer, String title, String select, String txt, String[] saveFnameValues) {


		if (saveFnameValues != null) {

			int startPos = 0;
			for (int i = 0; i < saveFnameValues.length; i++) {
				int imgPos = txt.indexOf("<img", startPos);
				if (imgPos == -1)
					break;
				
				String toReplace = "<img src=\'" + saveFnameValues[i] + "'>";
				txt = txt.substring(0, imgPos) + toReplace + txt.substring(txt.indexOf(">", imgPos) + 1);

				startPos = imgPos + toReplace.length();
			}
		}
		
		System.out.println("writer : " + writer);
		System.out.println("title : " + title);
		System.out.println("가공전 txt : " + txt);
		System.out.println("saveFnameValues : " + saveFnameValues);
		System.out.println("가공 후 txt : " + txt);
		System.out.println("select : " + select);

		return  nMapper.regNotice(writer, title, select, txt);
	}
	
	// 게시물 업데이트
	public int updateNotice(String title, String select, String txt, String seq, String[] saveFnameValues) {
		
		if (saveFnameValues != null) {

			int startPos = 0;
			for (int i = 0; i < saveFnameValues.length; i++) {
				int imgPos = txt.indexOf("<img", startPos);
				if (imgPos == -1)
					break;
				
				String toReplace = "<img src=\'" + saveFnameValues[i] + "'>";
				txt = txt.substring(0, imgPos) + toReplace + txt.substring(txt.indexOf(">", imgPos) + 1);

				startPos = imgPos + toReplace.length();
			}
		}
		
		System.out.println("title : " + title);
		System.out.println("가공전 txt : " + txt);
		System.out.println("saveFnameValues : " + saveFnameValues);
		System.out.println("가공 후 txt : " + txt);
		System.out.println("select : " + select);

		return nMapper.updateNotice(title, select, txt, seq);
	}

	public int deleteNotice(int an_seq) {
	
		return nMapper.deleteNotice(an_seq);
	}



}

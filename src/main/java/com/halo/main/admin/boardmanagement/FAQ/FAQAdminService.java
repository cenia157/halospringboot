package com.halo.main.admin.boardmanagement.FAQ;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.halo.main.user.faq.FAQVO;

@Service
public class FAQAdminService {

	@Autowired
	private FAQAdminMapper faqadminmapper;
	
	public List<FAQVO> getAllFAQsAdmin() {
		return faqadminmapper.getAllFAQsAdmin();
	}

	public FAQVO getFAQDetail(int qa_seq) {
		return faqadminmapper.getFAQDetail(qa_seq);
	}

	public List<FAQVO> getFAQListAdmin(int qa_seq) {
		return faqadminmapper.getFAQListAdmin(qa_seq);
	}

	public int updateFAQListAdmin(int seq, String title, String txt) {
		return faqadminmapper.updateFAQListAdmin(seq, title, txt);
	}

	// 이미지 업로드
	public ResponseEntity<?> uploadFile(MultipartFile file) {
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("File is empty");
		}

		try {
			String uploadDir = "src/main/resources/static/admin/boardmanagement/frequenthyask/0.img/upload";
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

//			System.out.println("파일경로 ::: " + filePath.toAbsolutePath().toString());
//			System.out.println("파일이름 :::: " + fileName);

			JSONObject jo = new JSONObject();
			jo.put("fName", "/admin/boardmanagement/faq/0.img/upload/" + fileName);

			return ResponseEntity.ok(jo.toJSONString());

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Could not upload the file: " + e.getMessage());
		}
	}


	
}

package com.halo.main.admin.userpage_update.logo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LogoDAO {

	@Autowired
	private LogoMapper logoMapper;

	public LogoDTO getLogoDTO() {
		return logoMapper.getLogoDTO();
	}

	public ResponseEntity<?> uploadFile(MultipartFile file) {
		if (file.isEmpty()) {
			ResponseEntity.badRequest().body("File is empty");
		}
		try {
			String uploadDir = "src/main/resources/static/user/upload_imgs";
			String originalFileName = file.getOriginalFilename();
			String fileName = originalFileName;
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println(filePath);
			
			JSONObject jo = new JSONObject();
			jo.put("uploadedImg", fileName);
			
			return ResponseEntity.ok(jo.toJSONString());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Could not upload the file");
		}

		
		

	}
}

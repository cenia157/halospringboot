package com.halo.main.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Utils {
	
	@Autowired
    private ResourceLoader resourceLoader;
	
	public void loadResource() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:");
        String absolutePath = resource.getFile().getAbsolutePath();
        System.out.println("src/main/resources의 절대 경로: " + absolutePath);
    }

    public Path getPath(String imagePath, String imageName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:");
        String absolutePath = resource.getFile().getAbsolutePath() + "/static/user/upload_imgs";
        Path uploadPath = Paths.get(absolutePath).resolve(imagePath);
        if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
        
        System.out.println("uploadImage의 절대 경로: " + absolutePath);
        
        return uploadPath.resolve(imageName);
    }
	
	public String currentDateTime() {
		
        // 현재 날짜와 시간 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 원하는 출력 형식 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");

        // 형식에 맞게 날짜와 시간을 문자열로 변환
        String formattedDateTime = currentDateTime.format(formatter);

		
		return formattedDateTime;
	}
	
public ResponseEntity<?> uploadFile(MultipartFile file, String uploadPath, int index) {
		
		if (file.isEmpty()) {
			ResponseEntity.badRequest().body("File is empty");
		}
		try {
			String originalFileName = file.getOriginalFilename();
			System.out.println(originalFileName.substring(originalFileName.lastIndexOf(".")));
			System.out.println("asd: "+originalFileName.lastIndexOf("."));
			String dateTime = this.currentDateTime();
			System.out.println(dateTime);
			String fileName;
			//파일명에 저장된 날짜시간 추가, 앞자리에-> 시간순정렬
			if(uploadPath.equals("banner")) 
				fileName = dateTime + uploadPath +index+ originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일명에 저장된 날짜시간 추가, 앞자리에-> 시간순정렬
			else 
				fileName = dateTime + uploadPath + originalFileName.substring(originalFileName.lastIndexOf("."));
			
			
			//절대경로
			Path filePath = this.getPath(uploadPath, fileName);
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

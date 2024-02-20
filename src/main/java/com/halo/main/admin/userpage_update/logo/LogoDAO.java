package com.halo.main.admin.userpage_update.logo;

import java.io.IOException;
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

import com.halo.main.util.Utils;

@Service
public class LogoDAO {

	@Autowired
	private LogoMapper logoMapper;
	
	@Autowired
	private Utils utils;
	
	//화면
	public LogoDTO getLogoDTO() {
		return logoMapper.getLogoDTO();
	}
	
	

	public ResponseEntity<?> uploadFile(MultipartFile file, String uploadPath, int index) {
		
		if (file.isEmpty()) {
			ResponseEntity.badRequest().body("File is empty");
		}
		try {
			String originalFileName = file.getOriginalFilename();
			System.out.println(originalFileName.substring(originalFileName.lastIndexOf(".")));
			System.out.println("asd: "+originalFileName.lastIndexOf("."));
			String dateTime = utils.currentDateTime();
			System.out.println(dateTime);
			String fileName;
			//파일명에 저장된 날짜시간 추가, 앞자리에-> 시간순정렬
			if(uploadPath.equals("banner")) 
				fileName = dateTime + uploadPath + "["+index+"]"+ originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일명에 저장된 날짜시간 추가, 앞자리에-> 시간순정렬
			else 
				fileName = dateTime + uploadPath + originalFileName.substring(originalFileName.lastIndexOf("."));
			
			
			//절대경로
			Path filePath = utils.getPath(uploadPath, fileName);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println(filePath);
			
			JSONObject jo = new JSONObject();
			jo.put("uploadedImg", fileName);
			jo.put("uploadedImgFullPath", filePath.toString().replace("\\", "\\\\"));
			System.out.println("?!?!?!!?: " + fileName);
			
			return ResponseEntity.ok(jo.toJSONString());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Could not upload the file");
		}
		
		
		
		
		
		

	}



	public ResponseEntity<?> updateLogo(LogoDTO ldto) {
		String isSuccess = "false";
		
		if (logoMapper.updateLogo(ldto) == 1) {
			System.out.println("logo update success");
			isSuccess = "true";
		}else {
			System.out.println("logo update faile");
		}
		
		JSONObject jo = new JSONObject();
		jo.put("isSuccess", isSuccess);
		
		return ResponseEntity.ok(jo.toJSONString());
	}
}

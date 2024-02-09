package com.halo.user.introduce.album;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class TokenConfigReader {
    
    public static String loadApiToken(String configPath, ServletContext context) {
    	// 프로퍼티 파일쓰려면 Properties객체 만들어야함
        Properties properties = new Properties();
        String apiToken = null;
        // 범용성: InputStream은 다양한 형식의 데이터를 읽어올 수 있으므로, 프로퍼티 파일 뿐만 아니라 이미지, 
        //       음악 파일, 텍스트 파일 등 다양한 종류의 리소스를 처리할 수 있습니다.
        try (InputStream input = context.getResourceAsStream(configPath)) {
            if (input != null) {
                properties.load(input);
                // 프로퍼티 파일에서 api.token = 값 이런식으로 있잖아 api.token -> 키라고 생각 
                apiToken = properties.getProperty("api.token");
            } else {
                System.out.println("프로퍼티 파일 경로 확인: " + configPath);
                System.out.println("프로퍼티 파일이 존재하지 않거나 열 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiToken;
    }
}

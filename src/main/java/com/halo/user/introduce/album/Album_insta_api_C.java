package com.halo.user.introduce.album;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.main.MainpageDAO;

@WebServlet("/Album_insta_api_C")
public class Album_insta_api_C extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 프로퍼티 파일을 만들어서 사용
        String configPath = "/user/introduce/album/token_config.properties";
        String apiToken = TokenConfigReader.loadApiToken(configPath, getServletContext());
        
        request.setAttribute("apiToken", apiToken);
        MainpageDAO.getMdao().getAllHompage_common(request);
        request.setAttribute("menu", "user/menu-index.jsp");
        request.setAttribute("subMenu", "/user/introduce/album/album_contentPage.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	requestInstagram(request, response);
    }
    
    /**
     * 인스타 api 요청
     * @param request
     * @param response
     */
    private void requestInstagram(HttpServletRequest request, HttpServletResponse response) {
    	try {
            // 요청을 보낼 URL 생성
    		String configPath = "/user/introduce/album/token_config.properties";
    		String apiToken = TokenConfigReader.loadApiToken(configPath, getServletContext());
            String urlString = "https://graph.instagram.com/me/media?fields=id,caption,media_type,media_url,permalink,thumbnail_url&access_token="+apiToken;
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

//            int responseCode = connection.getResponseCode();
//            System.out.println("응답 코드: " + responseCode);

            // 응답 내용 읽기
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder responseBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
            	responseBuilder.append(line);
            }
            reader.close();

            // 응답 내용 출력
//          System.out.println("응답 내용: " + responseBuilder.toString());
            
            response.getWriter().write(responseBuilder.toString());
            // 연결 종료
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

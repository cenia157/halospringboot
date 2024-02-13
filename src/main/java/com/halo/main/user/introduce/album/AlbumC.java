package com.halo.main.user.introduce.album;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@PropertySource("classpath:/static/user/introduce/album/token_config.properties")
public class AlbumC {

	@Value("${api.token}")
	private String apiToken;

	@GetMapping("/AlbumC")
	public String AlbumC(Model model) {

		model.addAttribute("apiToken", apiToken);
//		System.out.println("api토근값 :::" + apiToken);

//		MainpageDAO.getMdao().getAllHompage_common(request);
		model.addAttribute("menu", "/WEB-INF/views/user/menu-index.jsp");
		model.addAttribute("subMenu", "/WEB-INF/views/user/introduce/album/album_contentPage.jsp");

		return "index";
	}

	@ResponseBody
	@PostMapping("/Album_insta_api_C")
	public ResponseEntity<String> requestInstagram() {
		try {
			// API 요청 URL 구성
			String urlString = "https://graph.instagram.com/me/media?fields=id,caption,media_type,media_url,permalink,thumbnail_url&access_token="
					+ apiToken;
			System.out.println("Requesting Instagram API with URL: " + urlString); // URL 로그 출력

			// RestTemplate을 사용하여 인스타그램 API 요청
			RestTemplate restTemplate = new RestTemplate();
			String response = restTemplate.getForObject(urlString, String.class);

			// 응답 로그 출력
			System.out.println("Instagram API Response: " + response);

			// 성공적인 응답 반환
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			// 오류 로그 출력
			System.out.println("Error occurred while requesting Instagram API: " + e.getMessage());
			e.printStackTrace();

			// 오류 응답 반환
			return ResponseEntity.badRequest().body("Error occurred");
		}
	}
}
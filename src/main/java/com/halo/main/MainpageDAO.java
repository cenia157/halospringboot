package com.halo.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainpageDAO {

	private HomepageDTO hdto = new HomepageDTO(); // 인스턴스 생성자
	private static final MainpageDAO MDAO = new MainpageDAO(); // 상수(불변)

	private MainpageDAO() {
		// 외부에서 인스턴스 생성 막기 위해, private으로 기본생성자 잠금
	}

	public static MainpageDAO getMdao() {
		return MDAO;
	}

	public void getAllHompage_common(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from homepage_common";
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			HomepageDTO hdto = null;

			if (rs.next()) {
				hdto = new HomepageDTO();
				hdto.setH_seq(rs.getInt("h_seq"));
				hdto.setH_logo_img(rs.getString("h_logo_img"));
				hdto.setH_slogan(rs.getString("h_slogan"));
				// 메인(메인베너)빠른메뉴 url 컬럼으로 씀, 컬럼명 바꿀 예정
				hdto.setH_left_banner_title(rs.getString("h_left_banner_title"));
				hdto.setH_center_banner_title(rs.getString("h_center_banner_title"));
				hdto.setH_right_banner_title(rs.getString("h_right_banner_title"));
				// 메인(메인베너)빠른메뉴 text(title) 컬럼으로 쓸 예정, 컬럼명 바꿀 예정
				hdto.setH_left_banner_img(rs.getString("h_left_banner_img"));
				hdto.setH_center_banner_img(rs.getString("h_center_banner_img"));
				hdto.setH_right_banner_img(rs.getString("h_right_banner_img"));
				// 푸터 업뎃용--------------
				hdto.setH_tel_no(rs.getString("h_tel_no"));
				hdto.setH_fax_no(rs.getString("h_fax_no"));
				hdto.setH_phone_no(rs.getString("h_phone_no"));
				hdto.setH_email(rs.getString("h_email"));
				hdto.setH_address(rs.getString("h_address"));
				hdto.setH_resume_file(rs.getString("h_resume_file"));

				// 뷰에 뿌릴 어트리뷰트
				request.setAttribute("hdto", hdto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
			// 빠른메뉴 메인상단베너, 하단베너 출력
			getTopBanner(request);
			getBottomBanner(request);
		}

	}

	// 로고 미리보기 (멀티파트로 까서 어트리뷰트 넘겨주기만 하는 용도 DB는 변경버튼 누를때 업뎃메서드 사용예정)
	public void uploadLogo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String savepath = request.getServletContext().getRealPath("user/upload_imgs");
		MultipartRequest mr = new MultipartRequest(request, savepath, 1024 * 1024 * 20, "utf-8",
				new DefaultFileRenamePolicy());
		String fileName = mr.getFilesystemName("logo_img");
		System.out.println(fileName);

		response.getWriter().write(fileName);
	}

	// 로고 업데이트
	public void updateLogo(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String newFileName = request.getParameter("newFileName");
		String sql = "update homepage_common set h_logo_img = ? where h_seq=1";
		String paramName = "error";
		String param = "등록 실패";
		try {
			con = DBManagerhalo.connect();
//			System.out.println(newFileName);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newFileName);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공!");

				param = "등록 성공!";
				paramName = "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db server error...");
		} finally {
			request.setAttribute("paramName", paramName);
			request.setAttribute("param", param);
			DBManagerhalo.close(con, pstmt, null);
		}
	}

	// Footer업데이트
	public void updateFooter(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update homepage_common set h_tel_no=?, h_fax_no=?, h_phone_no=?, h_email=?, h_address=? where h_seq=1";
		String paramName = "error";
		String param = "등록 실패";
		try {
			request.setCharacterEncoding("utf-8");
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("h_tel_no"));
			pstmt.setString(2, request.getParameter("h_fax_no"));
			pstmt.setString(3, request.getParameter("h_phone_no"));
			pstmt.setString(4, request.getParameter("h_email"));
			pstmt.setString(5, request.getParameter("h_address"));
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공!");

				param = "등록 성공!";
				paramName = "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db server error...");
		} finally {
			request.setAttribute("paramName", paramName);
			request.setAttribute("param", param);
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	// 하단베너 DTO
	public void getBottomBanner(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select b_index, b_type, b_m_name, b_url, nvl(b_m_text, 'empty') as b_m_text, nvl(b_img_url, 'empty') as b_img_url from banner_tbl where b_index < 4 order by b_index";
		String paramName = "error";
		String param = "조회 실패";

		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<BannerInformDTO> bannersInform = new ArrayList<BannerInformDTO>();

			while (rs.next()) {
				BannerInformDTO tempBannerInform = new BannerInformDTO();
				tempBannerInform.setB_index(rs.getInt(1));
				tempBannerInform.setB_type(rs.getInt(2));
				tempBannerInform.setB_m_name(rs.getString(3));
				tempBannerInform.setB_url(rs.getString(4));
				tempBannerInform.setB_m_text(rs.getString(5));
				tempBannerInform.setB_img_url(rs.getString(6));

				System.out.println(tempBannerInform);

				bannersInform.add(tempBannerInform);
			}

			request.setAttribute("bottomBanners", bannersInform);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("paramName", paramName);
			request.setAttribute("param", param);
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	public void getTopBanner(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select b_index, b_type, b_m_name, b_url, nvl(b_m_text, 'empty') as b_m_text, nvl(b_img_url, 'empty') as b_img_url from banner_tbl where b_index > 3 order by b_index";
		String paramName = "error";
		String param = "조회 실패";

		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<BannerInformDTO> bannersInform = new ArrayList<BannerInformDTO>();

			while (rs.next()) {
				BannerInformDTO tempBannerInform = new BannerInformDTO();
				tempBannerInform.setB_index(rs.getInt(1));
				tempBannerInform.setB_type(rs.getInt(2));
				tempBannerInform.setB_m_name(rs.getString(3));
				tempBannerInform.setB_url(rs.getString(4));
				tempBannerInform.setB_m_text(rs.getString(5));
				tempBannerInform.setB_img_url(rs.getString(6));

//				System.out.println(tempBannerInform);

				bannersInform.add(tempBannerInform);
			}

			request.setAttribute("topBanners", bannersInform);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("paramName", paramName);
			request.setAttribute("param", param);
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	// 하단베너 업로드 ajax 미리보기 (멀티파트로 까서 어트리뷰트 넘겨주기만 하는 용도 DB는 변경버튼 누를때 업뎃메서드 사용예정)
	public void uploadBanner(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savepath = request.getServletContext().getRealPath("user/upload_imgs/banner/");
		MultipartRequest mr = new MultipartRequest(request, savepath, 1024 * 1024 * 20, "utf-8",
				new DefaultFileRenamePolicy());

		String fileName = mr.getFilesystemName("banner_thumbnail");
//		 System.out.println("업로드할 파일 :" + fileName);
		Gson gson = new Gson();
		gson.toJson(fileName);
		response.getWriter().print(fileName);
//		 System.out.println(fileName);

	}

	// 하단베너 업데이트
	public void updateBanner(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		String paramName = "error";
		String param = "등록 실패";

		try {
			con = DBManagerhalo.connect();

			String[][] bannerValues = { request.getParameterValues("selectValues"),
					request.getParameterValues("urlValues"), request.getParameterValues("pdNameValues"),
					request.getParameterValues("fileNameValues") };

			System.out.println(bannerValues.length);
			System.out.println(bannerValues[0].length);

			// 하단베너3개 => for문 i = name뒤에 붙을 인덱스번호,
			for (int i = 0; i < 3; i++) {
				if (bannerValues[0][i] != null && bannerValues[0][i].equals("sales")) {
					System.out.println("banner_menus[" + i + "] : " + bannerValues[0][i]);
					sql = "update banner_tbl \r\n"
							+ "set b_type = 2, b_m_name = 'sales', b_url = ?, b_m_text = ?, b_img_url = ? \r\n"
							+ "where b_index = " + (i + 1);
					pstmt = con.prepareStatement(sql);
					// 상품사이트 url
					pstmt.setString(1, bannerValues[1][i]);
//					System.out.println("배너url 파람 : " + bannerValues[1][i]);

					// 상품명:ㅁㅁ
					pstmt.setString(2, bannerValues[2][i]);
//					System.out.println("상품명 파람 : " + bannerValues[2][i]);

					// 배너 썸네일 이미지 이름
					pstmt.setString(3, bannerValues[3][i]);
//					System.out.println("업뎃파일 : "+ bannerValues[3][i]);

				} else {
					sql = "update banner_tbl \r\n"
							+ "set b_type = 1, b_m_name = ?, b_url = (select m_servlet from menu_tbl where m_name = ?), b_m_text = (select m_text from menu_tbl where m_name = ?) \r\n"
							+ "where b_index = " + (i + 1);

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bannerValues[0][i]);
					pstmt.setString(2, bannerValues[0][i]);
					pstmt.setString(3, bannerValues[0][i]);
				}
				if (pstmt.executeUpdate() > 0) {
//					System.out.println("bannerNo: " + i + "업뎃 성공");
				} else {
//					System.out.println("bannerNo: " + i + "업뎃 실패");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db server error...");
		} finally {
			request.setAttribute("paramName", paramName);
			request.setAttribute("param", param);
			DBManagerhalo.close(con, pstmt, null);
		}
	}

	// 메인페이지 베너 (빠른메뉴) 업뎃
	public void updateMainBanner(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String paramName = "error";
		String param = "등록 실패";
		String sql = "";

		try {
			con = DBManagerhalo.connect();
			String[] mainBannerValues = { request.getParameter("main_banner_box1"),
					request.getParameter("main_banner_box2"), request.getParameter("main_banner_box3") };
			System.out.println("mainBannerValues:" + mainBannerValues);
			for (int i = 0; i < 3; i++) {
				sql = "update banner_tbl \r\n" + "set b_m_name=?, \r\n"
						+ "b_url=(select m_servlet from menu_tbl where m_name =?), \r\n"
						+ "b_m_text = (select m_text from menu_tbl where m_name=?)\r\n" + "where b_index=?";
				System.out.println("mainBannerValues:[" + i + "]" + mainBannerValues[i]);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mainBannerValues[i]);
				pstmt.setString(2, mainBannerValues[i]);
				pstmt.setString(3, mainBannerValues[i]);

				pstmt.setInt(4, i + 4);

				if (pstmt.executeUpdate() > 0) {
//					System.out.println("메인bannerNo: " + (i+4) + "업뎃 성공");
				} else {
//					System.out.println("메인bannerNo: " + (i+4) + "업뎃 실패");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db server error...");
		} finally {
			request.setAttribute("paramName", paramName);
			request.setAttribute("param", param);
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	// 팝업 미리보기
	public void uploadPopup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savepath = request.getServletContext().getRealPath("user/upload_imgs/popupImg/");
		MultipartRequest mr = new MultipartRequest(request, savepath, 1024 * 1024 * 20, "utf-8",
				new DefaultFileRenamePolicy());

		String fileName = mr.getFilesystemName("thumbnail");
		System.out.println("업로드할 파일 :" + fileName);
		Gson gson = new Gson();
		gson.toJson(fileName);
		response.getWriter().print(fileName);
		System.out.println(fileName);

	}

	// 팝업 업뎃
	public void updatePopup(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String paramName = "error";
		String param = "등록 실패";
		String sql = "";

		try {
			con = DBManagerhalo.connect();
			String popupMenu = request.getParameter("popupMenu");
			String popupImg = request.getParameter("popupImg");

			if (popupMenu.equals("url")) {
				String popupUrl = request.getParameter("popupUrl");
				sql = "update popup_tbl set p_img=?, p_url=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, popupImg);
				pstmt.setString(2, popupUrl);
			} else {
				sql = "update popup_tbl set p_img=?, p_url=(select m_servlet from menu_tbl where m_name =?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, popupImg);
				pstmt.setString(2, popupMenu);
			}

			if (pstmt.executeUpdate() > 0) {
				System.out.println("업뎃 성공");
			} else {
				System.out.println("업뎃 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db server error...");
		} finally {
			request.setAttribute("paramName", paramName);
			request.setAttribute("param", param);
			DBManagerhalo.close(con, pstmt, null);
		}

	}

	public void getPopupInfoForAdmin(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p_img, p_url, p_flag, nvl(m_text,'URL') as m_text from popup_tbl left outer join menu_tbl on m_servlet = p_url";
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			PopupDTO pdto = null;

			if (rs.next()) {
				pdto = new PopupDTO();
				pdto.setP_img(rs.getString("p_img"));
				pdto.setP_url(rs.getString("p_url"));
				pdto.setP_flag(Integer.parseInt(rs.getString("p_flag")));
				pdto.setM_text(rs.getString("m_text"));

				// 뷰에 뿌릴 어트리뷰트
				System.out.println(rs.getString("m_text"));
				request.setAttribute("pdto", pdto);
				rs.getString("m_text");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
			// 빠른메뉴 메인상단베너, 하단베너 출력
			getTopBanner(request);
			getBottomBanner(request);
		}

	}

	public void popupSet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savepath = request.getServletContext().getRealPath("user/upload_imgs/popupImg/");
		MultipartRequest mr = new MultipartRequest(request, savepath, 1024 * 1024 * 20, "utf-8",
				new DefaultFileRenamePolicy());
		String update = null;
		String popupRadio = mr.getParameter("popup-radio");
		if (popupRadio.equals("0"))
			update = "Popup Off";
		else
			update = "Popup On";
		String sql = "update popup_tbl set p_flag=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(popupRadio));

			if (pstmt.executeUpdate() == 0) {
				System.out.println(update);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, null);
			// 빠른메뉴 메인상단베너, 하단베너 출력
			getTopBanner(request);
			getBottomBanner(request);
		}

		System.out.println("라디오 : " + popupRadio);

	}

	public void getPopupInfoForHC(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p_img, p_url, p_flag, nvl(m_text,'URL') as m_text from popup_tbl left outer join menu_tbl on m_servlet = p_url";
		try {
			con = DBManagerhalo.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			PopupDTO pdto = null;

			if (rs.next()) {
				pdto = new PopupDTO();
				pdto.setP_flag(Integer.parseInt(rs.getString("p_flag")));
				if (rs.getString("p_flag").equals("1")) {
					pdto.setP_img(rs.getString("p_img"));
					pdto.setP_url(rs.getString("p_url"));
					pdto.setM_text(rs.getString("m_text"));
				}
				// 뷰에 뿌릴 어트리뷰트
				System.out.println(rs.getString("m_text"));
				request.setAttribute("pdto", pdto);
				rs.getString("m_text");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerhalo.close(con, pstmt, rs);
			// 빠른메뉴 메인상단베너, 하단베너 출력
			getTopBanner(request);
			getBottomBanner(request);
		}

	}

}

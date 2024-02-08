package com.halo.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

@WebServlet("/AjaxLogoC")
public class AjaxLogoC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로고img 업뎃하는일
		System.out.println("22");
		
		if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest((RequestContext) request);
                for (FileItem item : items) {
                    if (!item.isFormField()) {
                        // 파일 업로드 처리
                        String fileName = new File(item.getName()).getName();
                        String filePath = "YOUR_UPLOAD_DIRECTORY" + File.separator + fileName;
                        File uploadedFile = new File(filePath);
                        item.write(uploadedFile);

                        // 업로드된 파일 경로를 클라이언트에게 응답
                        response.getWriter().write("{\"filePath\":\"" + filePath + "\"}");
                    }
                }
            } catch (Exception ex) {
                response.getWriter().write("{\"error\":\"" + ex.getMessage() + "\"}");
            }
        } else {
            response.getWriter().write("{\"error\":\"멀티파트 요청이 아닙니다.\"}");
        }
		
	}

}

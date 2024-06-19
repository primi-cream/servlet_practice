package cms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
// 파일 업로드 처리 코드
// @: 라이브러리를 객체화 하지않고 쉽게 로드를 할 수 있는 기능(XML 기능 중 하나)
@MultipartConfig(	// 첨부파일 환경설정
	fileSizeThreshold = 1024 * 1024 * 2,	// 한 개의 파일 전송 크기 : 2MB
	maxFileSize = 1024 * 1024 * 50,			// 업로드 가능한 최대 크기 : 50MB
	maxRequestSize = 1024 * 1024 * 100		// 여러개의 파일 전체 용량 : 100MB
)


public class fileok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// Part : interface api 자료형 (servlet 3.0) => file에만 사용
		Part mfile = request.getPart("mfile");	// 값이 null일 경우 에러
		String filename = mfile.getSubmittedFileName();	// 첨부파일명
		long filesize = mfile.getSize();	// 첨부파일 용량 (byte 단위로 체크)
		this.pw = response.getWriter();
		if(filesize > 2097152) {	//2MB 이하 제한
			this.pw.write("<script>"
					+ "alert('첨부파일 용량은 2MB 이하만 가능합니다.');"
					+ "history.go(-1);"
					+ "</script>");
		} else {	// 2MB 이하일 경우
			// request.getServletContext() : 웹 경로를 설정하는 class
			// getRealPath() : web directory path
			if(filename != "" && filesize > 0) {	// 첨부파일명과 파일크기를 확인 후 웹 디렉토리에 저장
				String url = request.getServletContext().getRealPath("/shop/fileupload/");
				mfile.write(url + filename);	// 해당 웹 경로에 파일을 저장시킴
			}
		}
		this.pw.close();
	}
}

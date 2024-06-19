package cms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
	fileSizeThreshold = 2097152, 
	maxFileSize = 1024 * 1024 * 10,
	maxRequestSize = 1024 * 1024 * 100
)

// 파일 전송에 따른 Databse 저장기능 추가
public class fileok2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	dbconfig db = new dbconfig();
	Connection con = null;
	PrintWriter pw = null;
	Statement st = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String mreview = request.getParameter("mreview");
		Part mfile = request.getPart("mfile");
		String filename = mfile.getSubmittedFileName(); // 파일명
		long filesize = mfile.getSize();
		try {
			this.con = this.db.info();
			this.pw = response.getWriter();
			if(filename == "" || filesize <= 0) {	// 첨부파일이 없는 상황
				String sql = "INSERT INTO filelist (fidx,f_img,f_text,f_indate) VALUE ("
						+ "'0','','"+ mreview +"',now()"
						+ ")";
				this.st = this.con.createStatement();
				int result = this.st.executeUpdate(sql);
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('업로드 성공!')"
							+ "</script>");
				} else {
					this.pw.write("<script>"
							+ "alert('업로드 실패!')"
							+ "</script>");
				}
			} else { // 첨부파일이 있는 상황
				String url = request.getServletContext().getRealPath("/upload/");
				mfile.write(url+filename);
				String filesave = "./upload/" + filename;	// db에 저장되는 경로
				String sql = "INSERT INTO filelist (fidx,f_img,f_text,f_indate) "
						+ "VALUE ('0','"+ filesave +"','"+ mreview +"',now())";
				
				this.st = this.con.createStatement();
				int result = this.st.executeUpdate(sql);
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('정상적으로 리뷰가 등록 완료 되었습니다.');"
							+ "location.href='./upload_list.do';"
							+ "</script>");
				} else {
					this.pw.write("<script>"
							+ "alert('올바른 파일이 아닙니다.');"
							+ "history.go(-1);"
							+ "</script>");
				}
			}
		} catch(Exception e) {
			System.out.println("Database 접속 오류 및 Web Directory 오류 발생");
		} finally {
			try {
				this.st.close();
				this.pw.close();
				this.con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		
	}

}

package cms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원가입 페이지
public class insertok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	dbconfig db = new dbconfig();	//db정보
	PrintWriter pw = null;
	private Connection con = null;
	private Statement st = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uid = request.getParameter("uid");
		String upass = request.getParameter("upass");
		String uname = request.getParameter("uname");
	
		
		try {
			this.con = this.db.info();
			// sql 문법(dml)
			String sql = "INSERT INTO user (uidx, uid, upass, uname, ujoin) "
					+ "VALUES ('0','" + uid + "','" + upass + "','" + uname + "',now())";
			this.st = this.con.createStatement();	// sql 문법 실행시키는 Libary
			int result = this.st.executeUpdate(sql); // 실행 및 결과값을 return(숫자)
			this.pw = response.getWriter();
			if(result > 0) {	//정상적인 query 작동
				this.pw.write("<script>"
						+ "alert('회원가입이 완료 되었습니다.')"
						+ "location.href='./login.html'"
						+ "</script>");
			} else {	// 오류 query 작동
				this.pw.write("<script>"
						+ "alert('회원가입 실패!!!');"
						+ "history.go(-1);"
						+ "</script>");
			}
		} catch (Exception e) {
			System.out.println("Database 연결실패!!");
		} finally {
			try {
				this.pw.close();
				this.st.close();
				this.con.close();
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Database 접속해제 실패");
			}
		}
	}

}

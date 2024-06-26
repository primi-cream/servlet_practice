package cms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	dbconfig db = new dbconfig();
	Connection con = null;
	Statement st = null;
	PrintWriter pw = null;
	HttpSession hs = null;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			String uid = request.getParameter("uid");
			String upass = request.getParameter("upass");
			
			this.con = this.db.info();
			String sql="SELECT * FROM user WHERE uid='" + uid + "' AND upass='" + upass +"'";
			this.st = this.con.createStatement();
			ResultSet rs = this.st.executeQuery(sql);	// ResultSet : SELECT 문에서만 사용하는 Library
			// ResultSet이란 : 배열형태(db전용배열) + BufferedReader(기능포함)
			// getString, getInt, getLong, getArray ... : 데이터베이스에 맞는 자료형을 가져올 때
			// getDate : 날짜만 출력, getTime : 시간만 출력
			this.pw = response.getWriter();
			String mid = "";	// 아이디
			String mname = "";	// 고객명
			
			// DB에 있는 사용자 1인에 대한 정보를 변수에 저장하는 방식
			while(rs.next()) {
				mid = rs.getString("uid");
				mname = rs.getString("uname");
//				System.out.println(rs.getDate(5));
//				System.out.println(rs.getInt(4));
			}
			if(mname.equals("") || mid.equals("")) {	// select의 값이 없을 경우
				this.pw.write("<script>alert('아이디 및 비밀번호를 확인하세요');"
						+ "history.go(-1);"
						+ "</script>");
			} else {	// 해당 sql query가 정상 작동하여 값을 로드하였을 경우
				// mid, mname 변수가 빈값이 아닐경우 session 생성
				this.hs = request.getSession();
				this.hs.setAttribute("id", mid);
				this.hs.setAttribute("name", mname);
				
				this.pw.write("<script>alert('로그인 되셨습니다.');"
						+ "location.href='./top.jsp';"
						+ "</script>");
			}
			this.pw.close();
			rs.close();
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("DB 연결 실패!!");
		} finally {
			try {
				this.st.close();
				this.con.close();
			}catch (Exception e) {
				System.out.println("DB해제 실패!!");
			}
		}
	}

}

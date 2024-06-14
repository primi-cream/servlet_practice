package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class member_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String ag1 = request.getParameter("ag1");	// 동의 ("Y")
		String ag2 = request.getParameter("ag2");	// 동의 ("Y")
		
		String id = request.getParameter("mid");
		String pw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String cellPhone = request.getParameter("cellPhone");
		String mtel = request.getParameter("mtel");
		
		String event_mail = request.getParameter("event_mail");	//정보 수신 동의("Y","")
		String event_sms = request.getParameter("event_sms");	// sms 수신동의("Y","")
	
		System.out.println(event_mail);
		//주소
		String addr_post = request.getParameter("addr_post");
		String addr = request.getParameter("addr");
		String addr2 = request.getParameter("addr2");
		System.out.println(event_mail);
		//DB연결
		try {
			dbinfo db = new dbinfo();
			Connection ct = db.getConnection();
			//System.out.println("정상적으로 DB 연결 완료!");
			String sql = "INSERT INTO easy_member"
					+ "(no,id,pw,name,email,email_ok,tel,tel_ok,hp,address,terms_ok,user_info_ok,create_date,address_detail)"
					+ "VALUES('0',?,?,?,?,?,?,?,?,?,?,?,now(),?)";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1,"id");
			ps.setString(2,"pw");
			ps.setString(3,"mname");
			ps.setString(4,"memail");
			ps.setString(5,"event_mail");
			ps.setString(6,"mtel");
			ps.setString(7,"event_sms");
			ps.setString(8,"cellPhone");
			ps.setString(9,"addr");
			ps.setString(10,"agl");
			ps.setString(11,"ag2");
			ps.setString(12,"address_detail");
			
			int result = ps.executeUpdate();
			PrintWriter pwr = response.getWriter();
			if(result > 0) {
				pwr.write("<script>alert('정상적으로 회원가입이 완료 되었습니다.'); "
						+ "location.href='./agree.html';"
						+ "</script>");
			} else {
				pwr.write("<script>"
						+ "alert('아이디 및 데이터 정보 오류로 인하여 가입이 취소되었습니다.');"
						+ "location.href='./agree.html';"
						+ "</script>");
			}
			
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("Database에 접속 오류가 발생하였습니다.");
		}
		
		
	}

}

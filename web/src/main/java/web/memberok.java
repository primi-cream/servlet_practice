package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class memberok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	ArrayList<String> member = null;
	
	public memberok() {
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html");
		this.member = new ArrayList<String>();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html; charset=utf-8");
		new member_box(response);
		this.pw = response.getWriter();
		String msg = "";
		
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		if(mid.equals(mpass)|| mid.equals("admin")) {
			msg = "alert('해당 아이디는 사용불가합니다.'); history.go(-1);";
		} else {
			Date today = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sf.format(today);
			this.member.add(mid);
			this.member.add(mpass);
			this.member.add(date);
			System.out.println(this.member);
		}
		this.pw.write("<script>"
				+ msg
				+ "</script>");
		
		this.pw.flush();
		this.pw.close();
		
	}
}

class member_box{
	public member_box(HttpServletResponse response){
		response.setContentType("text/html; charset=utf-8");
		System.out.println(response);
	}
}


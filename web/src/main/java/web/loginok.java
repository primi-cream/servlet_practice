package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Controller - login(login_part.java)	
public class loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private login_part lp = new login_part();
	String msg = "";	// 결과값을 받는 전역변수
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String part = request.getParameter("part").intern();
		String mid = request.getParameter("mid").intern();
		String mpass = request.getParameter("mpass").intern();
		
		if(part == "C") {	// 사업자 회원
			String corpno = request.getParameter("corpno").intern();
			System.out.println(corpno);
			this.msg = this.lp.corps(mid, mpass, corpno);	// Module class에 있는 해당 메소드 값을 리턴받음
		} else {	// 일반 회원
			this.msg = this.lp.person(mid,mpass);
		}
		this.pw = response.getWriter();
		this.pw.print(this.msg);
		this.pw.flush();
		this.pw.close();
	}

}

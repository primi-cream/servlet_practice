package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	ArrayList<String> userList = null; 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String id = null;
		String pw = null;
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
//		System.out.println(request.getParameter("no") + "test");

		System.out.println(request.getParameter("no") == "");
		System.out.println(request.getParameter("no").equals(""));
	
		String ck = request.getParameter("no");
		this.pw = response.getWriter();
		if(ck == "") {
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			if(id.equals("apink") && pw.equals("0486")) {
				this.pw.write("<script>"
						+ "alert('로그인 되셨습니다.');"
						+ "</script>");
			} else {
				this.pw.write("<script>"
						+ "alert('아이디 및 패스워드를 확인하지 못했습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			
			this.pw.write("<script>"
					+ "</script>");
			System.out.println("일반");
		} else {
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			String no = request.getParameter("no");
			if(id.equals("sm") && pw.equals("sm1234") && no.equals("1346453478")) {
				this.pw.write("<script>"
						+ "alert('로그인 되셨습니다.');"
						+ "</script>");
			} else {
				this.pw.write("<script>"
						+ "alert('패스워드 및 사업자번호 정보를 확인하지 못했습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			System.out.println("사업자");
		}
		
		this.pw.flush();
		this.pw.close();
	}

}

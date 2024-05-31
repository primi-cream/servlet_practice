package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class info2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String mail = request.getParameter("email");
		String domain = request.getParameter("domain");
		this.pw = response.getWriter();
		
		if(mail.equals("apink") && domain.equals("naver.com")) {
			System.out.println("test");
			this.pw.write("<script>"
					+ "alert('해당 메일은 이미 등록되어 있는 메일입니다.');"
					+ "history.go(-1);"
					+ "</script>");
		} else {
			this.pw.write("<script>"
					+ "alert('메일이 등록되었습니다.');"
					+ "</script>");
		}
		
	}

}

package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String part = request.getParameter("part");
		this.pw = response.getWriter();
		String mid = "";
		String mpass = "";
		if(part.equals("1")) {
			mid = request.getParameter("mid");
			this.pw.write("<script>"
					+ "localStorage.setItem('mid','" + mid + "');"
					+ "location.href = './test4.html';" 
					+ "</script>");
		} else {
			mid = request.getParameter("mid");
			mpass = request.getParameter("mpass");
			System.out.println("mid : "  + mid + "pass : " + mpass);
			if(mid.equals("apink") && mpass.equals("1004")){
				this.pw.print("로그인 하셨습니다.");
			} else {
				this.pw.write("<script>"
						+ "localStorage.clear();"
						+ "alert('아이디 및 패스워드를 다시 확인하세요');"
						+ "loaction.href='./test3.html';"
						+ "</script>");
			}
		}
		this.pw.flush();
		this.pw.close();
	}

}

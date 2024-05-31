package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter pw = null; 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		this.pw = response.getWriter();
	
		String assessed = request.getParameter("assessed");
		String review_description = request.getParameter("review_description");
		String star = "";
		
		System.out.println(assessed);
		int num = Integer.parseInt(assessed);
		while(0 < num) {
			star+="★";
			num--;
		}
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/mm");
		
		this.pw.write("<script>"
				+ "alert('[상품리뷰]"+ review_description +" - " + date.format(d) + " " + star +"');"
				+ "</script>");
		
	}

}

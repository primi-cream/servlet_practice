package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Agreement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, String> agdata = null; 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		String agck[] = request.getParameterValues("agree");
		this.agdata = new LinkedHashMap<String, String>();
		
		for(String a : agck) {
			String arr[] = a.split("_");
			this.agdata.put(arr[0], arr[1]);
		}
		
		System.out.println(agdata);
		
	}

}

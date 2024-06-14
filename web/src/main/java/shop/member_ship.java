package shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class member_ship extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ag1 = request.getParameter("ag1");
		String ag2 = request.getParameter("ag2");
		
		// Attribute("가상의변수명",실제값(변수값))
		request.setAttribute("ag1", ag1);
		request.setAttribute("ag2", ag2);
		RequestDispatcher rd = request.getRequestDispatcher("member_ship.jsp");
		rd.forward(request, response);
	}

}

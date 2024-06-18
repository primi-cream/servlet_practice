package cms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//session 사용
public class session2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// cache 메모리에 있는 session값을 가져오는 형태
		System.out.println(session.getAttribute("id"));
		System.out.println(session.getAttribute("name"));
		System.out.println(session.getMaxInactiveInterval());	// session 유지시간을 확인하는 클래스
	}

}

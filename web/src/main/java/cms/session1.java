package cms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// session 생성
/*
 * Cookie : 브라우저에 Cache 메모리에 값을 저장하는 방식 (20개)	(Front, Back)
 * Session : 일정시간 동안 브라우저에 해당 값을 저장 및 유지시키는 방식 (Back-end)
 * Storage(session): Cache Memory (local-front,session-back)
 * 
 * 각각의 브라우저 별로 session이 작동을 하게됩니다.
 */
public class session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = "apink";
		String username = "에이핑크";
		HttpSession session = request.getSession();	// Catche Memory를 활성화
		//session을 생성함 
		session.setAttribute("id", userid);
		session.setAttribute("name", username);
	}

}

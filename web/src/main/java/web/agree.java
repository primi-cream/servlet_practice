package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class agree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// checkbox는 기본적으로 value값을 적용하게 되어 있습니다.
		// 해당 값이 없을 경우 null 적용되며, 해당 파라미터를 처음부터 변수선언 시 조건문에 error 발생하게 됩니다.
		// 또한 equals라는 메소드를 사용하게 되면 문제가 발생합니다.
		String ck = request.getParameter("ck");
		if(ck == null) {
			ck = "N";
		} else {
			ck = request.getParameter("ck");
		}
		System.out.println(ck);
		
		// radio 처리방식 : 무조건 데이터가 전송됩니다. on/off 형태로 조정이 되며
		// 중복 name을 사용하므로 value를 무조건 사용하게 됩니다.
		String ag = request.getParameter("ag").intern();	//intern 사용시 연산기호 가능
		
		System.out.println(ag);	// value 존재 시 value 우선, 없을 시 on/off
		
		// 동의 안함 HTML Tag에서 value값이 없을 경우 on으로 표기 있을 경우 동의함의 value값 agree_Y가 표기
		if(ag == "on") {
			System.out.println("동의안함");
		} else {
			System.out.println("동의함");
		}
	}

}

package web;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Java 암호화 (base64)
public class securityok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Front 에서 base64로 암호화된 값을 복호화하여 데이터값을 확인하는 방식
		String pwd = request.getParameter("pwd").intern();
		Decoder code = Base64.getDecoder();
		byte code2[] = code.decode(pwd);
		System.out.println(new String(code2));
		
		// 모든 암호화는 byte로 변환이 되어서 사용해야함
		
		// base64 사용법 문자를 byte로 변환 후 해당 byte를 라이브러리를 통하여 암호화
		String word = "a12345";
		byte a[] = word.getBytes();
		Encoder ec = Base64.getEncoder();
		byte b[] = ec.encode(a);
		System.out.println(new String(b));
		
		// base64 decode 사용법 문자를 byte로 변환후 라이브러리를 통하여 복호화
		String word2 = "YTEyMzQ1";
		Decoder dc = Base64.getDecoder();
		byte c[] = dc.decode(word2);
		System.out.println(new String(c));
		}

}

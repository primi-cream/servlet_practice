package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter pw = null;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String money = request.getParameter("money");
		String coupon = request.getParameter("coupon");
		this.pw = response.getWriter();
		if(money.equals("")) {
			this.pw.write("<sicrpt>alert('올바른 접근이 아닙니다.'); history.go(-1);</scirpt>");
		} else {
			int no1 = Integer.valueOf(money); // 결제금액
			int no2 = Integer.valueOf(coupon); // 쿠폰 적용 숫자
		
			// 할인율 0.1 ~ 0.9 (소수점) 정가 * (100% - 할인율)
			
			double total = (double)no1*(100-no2);
			System.out.println(total);
		}
		
		
	}

}

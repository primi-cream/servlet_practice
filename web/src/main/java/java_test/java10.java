package java_test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class java10 extends java10_box{

	public static void main(String[] args) {
		
		java10 a = new java10(); 
		
		System.out.print("[1.휴대폰 인증, 2.이메일 인증] 선택 :");
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		if(n == 1) {
			System.out.print("휴대폰 번호를 입력하세요(숫자만) : ");
		} else {
			System.out.print("이메일을 입력하세요 :  ");
		}
		
		scanner.nextLine();
		if(a.authentication(n,scanner.nextLine())) {
			System.out.println("인증번호 : " + a.send() + " 발송!");
		} else {
			System.out.println("잘못된 입력!");
		}
		
		scanner.close();
	}

	@Override
	boolean authentication(int num,String user_info) {
		Pattern pattern;
		String p = null;
		if(num==1) {
			p = "^010(\\d{3}|\\d{4})\\d{4}$";
			pattern = Pattern.compile(p);
		} else {
			p = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
			pattern = Pattern.compile(p);
		}
		return Pattern.matches(p, user_info);
	}

}

abstract class java10_box{
	
	abstract boolean authentication(int num,String user_info);
	
	public String send() {
		String auth="";
		
		int w = 0;
		while(w < 4) {
			auth+=(int)Math.ceil(Math.random()*9);
			w++;
		}
		
		return auth;
	}
	
}
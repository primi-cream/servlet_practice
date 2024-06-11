package java_test;

import java.util.Scanner;

public class java3 {

	public static void main(String[] args) {
		ass a = new ass();
		a.create_number();
		a.user_number();
	}

}

class ass{
	
	final int LEN = 6;
	private String number = "";
	private Scanner scanner = null;
	
	public void create_number() {
		int w=0;
		while(w < this.LEN){
			this.number += (int)Math.ceil(Math.random()*9);
			w++;
		}
		System.out.println(this.number);
	}
	
	public void user_number() {
		this.scanner = new Scanner(System.in);
		
		int w=0;
		String userNum="";
		while(true) {
			System.out.print("인증번호 입력 : ");
			userNum += this.scanner.nextInt();
			System.out.println(userNum);
			
			if(check(userNum)) {
				System.out.println("인증이 완료되었습니다.");
				break;
			} else {
				System.out.println("인증번호를 확인 후 동일한 번호를 입력하세요.");
			}
		}
		scanner.close();
	}
	
	public boolean check(String userNum) {
		return this.number.equals(userNum);
	}
}

package java_test;

import java.util.Scanner;

public class java2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("숫자입력 : ");
			if(scanner.nextInt()%2 == 0) {
				System.out.println("짝수");
			} else {
				System.out.println("홀수");
			}
		} catch (Exception e) {
			System.out.println("숫자만 입력하세요.");
		}
		scanner.close();
	}

}

package java_test;

import java.util.Arrays;
import java.util.Scanner;

public class java4 {

	public static void main(String[] args) {
		java4_box box = new java4_box();
		box.input();
		box.print();
	}

}

class java4_box{
	final int LEN = 5;
	private int[] arr = new int[LEN];
	private Scanner scanner = new Scanner(System.in);
	private int count = 0;
	
	public void input() {
		int w = 0;
		while(w < LEN) {
			System.out.print("숫자를 입력 : ");
			arr[w]=scanner.nextInt();
			check(arr[w]);
			w++;
		}
		scanner.close();
	}
	
	
	private void check(int num) {
		if(num%2 == 0)
			count++;
	}
	
	public void print() {
		System.out.println("[결과]");
		System.out.println(Arrays.toString(arr));
		System.out.println("짝수는 총 " + count + "개 입력하였습니다.");
	}
	
}
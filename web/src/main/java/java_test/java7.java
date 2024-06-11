package java_test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class java7 {

	public static void main(String[] args) {
		new java7_box().print();
	}

}

class java7_box{
	private Scanner scanner = null;
	private String name = "";
	private String content = "";
	
	public void print() {
		scanner = new Scanner(System.in);
		System.out.print("이름을 입력 : ");
		this.name = scanner.nextLine();
		System.out.print("내용을 입력 : ");
		this.content = scanner.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(this.name + " - " + this.content + format.format(new Date()));
		
		scanner.close();
		
	}
	
}

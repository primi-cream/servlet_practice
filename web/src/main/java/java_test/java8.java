package java_test;

import java.util.HashMap;
import java.util.Scanner;

public class java8 {

	public static void main(String[] args) {
		HashMap<String, String> user_info = new HashMap<String, String>();
		
		user_info.put("마동석", "01053514423");
		user_info.put("김무열", "01023103637");
		user_info.put("이동휘", "01055317889");
		user_info.put("박지환", "01069882901");
		user_info.put("이주빈", "01095849004");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("고객명을 입력 : ");
		String user_name = scanner.nextLine();
		System.out.println(user_name + "님 연락처는 " + user_info.get(user_name) + " 입니다.");
		scanner.close();
	}

}

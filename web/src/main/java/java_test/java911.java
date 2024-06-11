package java_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class java911 {
	public void main(String[] args) {
		List<String> user = new LinkedList<String>(Arrays.asList("스마트워치","카메라","킥보드","노트북","프린터","세탁기","무선청소기","냉장고","안마기","공기청정기")); 
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삭제하실 상품명을 입력 : ");
		user.remove(scanner.nextLine());
		
		scanner.close();
		
	}
}

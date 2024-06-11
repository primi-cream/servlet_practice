package java_test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class java6 {

	public static void main(String[] args) {
		int w = 10;
		List<Integer> arr = new ArrayList<Integer>();
		while(w > 0) {
			arr.add((int)Math.ceil(Math.random()*50));
			w--;
		}
		
		arr.sort(Comparator.reverseOrder());
		System.out.println(arr);
	}

}

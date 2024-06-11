package java_test;

import java.util.ArrayList;
import java.util.List;

public class java5 {

	public static void main(String[] args) {
		new java5_box().print();  
	}

}

class java5_box{
	
	int[] arr =  {3, 5, 2, 1, 6, 7, 8, 9, 10, 4};
	List<Integer> odd = new ArrayList<Integer>();
	List<Integer> even = new ArrayList<Integer>();
	public void print() {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2 == 0) {
				even.add(arr[i]);
			} else {
				odd.add(arr[i]);
			}
		}
		System.out.println(even);
		System.out.println(odd);
	}
}

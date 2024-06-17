package java_practice.poly;

public class TestP {

	public static void main(String[] args) {
		R r1 = new R(100,200);
		R r2 = new R(100,200);
		
		System.out.println(r1); // r(width :100, height:200)
		System.out.println(r2);
		System.out.println(r1 == r2); // f
		System.out.println(r1.equals(r2)); // t
	}

}

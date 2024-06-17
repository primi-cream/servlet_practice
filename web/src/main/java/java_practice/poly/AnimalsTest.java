package java_practice.poly;

public class AnimalsTest {
	public static void main(String[] args) {
		Birds b = new Birds();
		System.out.println(b);
		
		// UpCasting
		Animal a = b;
		System.out.println(a);
	
		// DownCasting
		Birds b2 = (Birds)a;
		System.out.println(b2);
		
		System.out.println(b2 instanceof Eagle);
		
	}
}

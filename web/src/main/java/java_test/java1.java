package java_test;

public class java1 {

	public static void main(String[] args) {
		new cal().calculate();
	}

}

class cal{
	public void calculate() {
		int num = 4;
		
		for(int i=2; i<=num; i++) {			
			for(int j=1; j<num; j++) {
				System.out.println(i + " * " + j + " = " + i*j);				
			}
		}
		
	}
}

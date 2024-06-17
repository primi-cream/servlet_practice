package java_practice.poly;

public class TestSound {
	public static void main(String[] args) {
		System.out.println("Test Inheritance");
		Object o = new Cat();
		Object b = new Dog();
		
		if(o instanceof Cat) {
			Cat cat = (Cat)o;
			cat.sound();						
		}
		
		if(b instanceof Dog) {
			Dog dog = (Dog)b;
			dog.sound();
		}
	}
}

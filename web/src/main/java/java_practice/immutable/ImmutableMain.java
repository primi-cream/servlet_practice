package java_practice.immutable;

public class ImmutableMain {
	public static void main(String[] args) {
		String a = "s";
		String b = "s";
		
		
		System.out.println(a.equals(b));
		System.out.println(a == b);
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		System.out.println("=========================");
		
		Id id = new Id("i");
		
//		User user1 = new User(id,"you");
//		User user2 = new User(id,"i");
		
//		System.out.println(user1.a.getId());
//		user2.immutable_id("side");
//		System.out.println(user2.a.getId());
//		System.out.println(user1.a.getId());
	}

}

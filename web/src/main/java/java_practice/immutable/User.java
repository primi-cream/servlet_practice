package java_practice.immutable;

public class User {
	private String name;
	Id a;
	
	public User(String id, String name) {
		immutable_id(id);
		setName(name);
	}
	
	
	public Id immutable_id(String id) {
		return a = new Id(id);
	}
	
	public String setName(String name) {
		this.name = name;
		return this.name;
	}
	
	public void printing() {
		System.out.println(a.getId());
	}
}

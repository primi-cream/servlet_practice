package java_practice.poly;

public class R {
	
	private int width;
	private int height;
	
	public R(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "(width : " + width + ", height : " + height +")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		R r = (R)obj;
		
		return this.width == r.width && this.height == r.height;
	}
	
}

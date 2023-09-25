package cs1332.module0;

class Container<T> {
	private T t;
	
	public Container(T t) {
		this.t=t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class Hero implements Comparable<Hero>{
	private int hp;
	private int mp;
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	//override
	public int compareTo(Hero h) {
		if(this.hp<h.hp) return -1;
		else if( this.hp>h.hp) return 1;
		else return 0;
	}
	public int compare(Hero h1,Hero h2) {
		return 1;
	}
}


public class Main {
	public static void main(String[] args) {
		
		Container<String> c1 =new Container<>("Hello");
		String s = c1.getT();
		
		Container<Integer> c2 = new Container<>(1);
		int i = c2.getT();
	   
	}

}

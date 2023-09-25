package cs1332.module6;

public class Main {
	
	public static void Main(String[] args) {
		int n=5;
		String[] a = new String[n];
		for(Integer i=0;i<n;i++) {
			a[i]=i.toString();
			System.out.println(a[i]);
		}
		
		String tmp=a[0];
		a[1]=a[0];
		a[0]=tmp;
		tmp=null;
		for(Integer i=0;i<n;i++) {
			System.out.println(a[i]);
		}
		
	}

}

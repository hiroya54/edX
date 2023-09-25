package cs1332.module1;

import java.util.Scanner;

public class Main {
	static void recursive(int[] a, int[] b, int n) {	
		if(n==0) {
			b[n]=1;
			return;
		}
		recursive(a,b,n-1);
		if(n==1) {
			b[n]=1;
			return;
		}
		//b[n]だけのケースをたす
		b[n]++;
		//ループ
		for(int i=0;i<n;i++) {
			if(a[n-1]>a[i]) {
				b[n]+=b[i+1];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		int[] b = new int[n+1];
		recursive(a,b,n);
		int res=0;
		for(int val: b) {
			res+=val;
		}
		System.out.println(res);

	}

}

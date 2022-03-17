package 백준수학;

import java.util.Scanner;

public class BOJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcdNum=gcd(a, b);
		
		System.out.println(gcdNum);
		System.out.println((a*b) / gcdNum);
	}
	
	static int gcd(int a, int b) {
		if(b == 0) 
			return a;
		else 
			return gcd(b, a%b);
	}

	
}

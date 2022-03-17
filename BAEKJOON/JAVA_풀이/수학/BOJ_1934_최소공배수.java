package 백준수학;

import java.util.Scanner;

public class BOJ_1934_최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc=0; tc<TC; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println((a*b) / gcd(a, b));
			
		}
	}
	static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
}

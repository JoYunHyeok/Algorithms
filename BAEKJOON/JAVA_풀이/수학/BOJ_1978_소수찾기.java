package 백준수학;

import java.util.Scanner;

public class BOJ_1978_소수찾기 {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int num = sc.nextInt();
			
			if(search(num))
					cnt++;
		}
		
		System.out.println(cnt);
	}
	static boolean search(int num) {
		if(num <= 1) return false;
		
		for(int i=2; i<=num/2; i++) {
			if(num % i ==0) return false;
		}
		return true;
	}
}

package 백준수학;

import java.util.Scanner;

public class BOJ_1929_소수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i=M; i<=N; i++) {
			if(search(i)) {
				System.out.println(i);
			}
		}
	}
	static boolean search(int num) {
		if(num <= 1) return false;
		
		for(int i=2; i*i<=num; i++) {
			if(num % i ==0) return false;
		}
		return true;
	}
}

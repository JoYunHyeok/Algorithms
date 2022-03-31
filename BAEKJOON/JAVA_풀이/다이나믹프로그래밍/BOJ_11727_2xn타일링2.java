package dp;

import java.util.Scanner;

public class BOJ_11727_2xn타일링2 {
	static int[] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		D = new int[1001];
		
		D[1] = 1;
		D[2] = 3;
		for(int i=3; i<=N; i++) {
			D[i] = D[i-1] + D[i-2]*2;
			D[i] %= 10007;
		}
		
		System.out.println(D[N]);
	}

}

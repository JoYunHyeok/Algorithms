package dp;

import java.util.Scanner;

public class BOJ_11726_2xn타일링 {
	static int N;
	static int[] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		D = new int[1001];
		D[1] = 1;
		D[2] = 2;	
		
		for(int i=3; i<=N; i++) {
			D[i] = D[i-1] + D[i-2];
			D[i] %= 10007;
		}
		System.out.println(D[N]);
		
	}

}

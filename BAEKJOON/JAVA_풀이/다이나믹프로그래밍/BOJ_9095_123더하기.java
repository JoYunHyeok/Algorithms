package dp;

import java.util.Scanner;

public class BOJ_9095_123더하기 {
	static int TC;
	static int[] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		D = new int[11];
		D[0] = 1;
		D[1] = 1;
		D[2] = 2;
		for(int tc=0; tc<TC; tc++) {
			int n = sc.nextInt();
			
			for(int i=3; i<=n; i++) {
				D[i] = D[i-1] + D[i-2] + D[i-3];
			}
			System.out.println(D[n]);
		}
	}

}

package day0331;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	static int[] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		D = new int[N + 1];
		D[1] = 0;
		for (int i = 2; i <= N; i++) {
			D[i] = D[i - 1] + 1;
			if (i % 2 == 0 && D[i / 2] + 1 < D[i]) D[i] = D[i / 2] + 1;
			if (i % 3 == 0 && D[i / 3] + 1 < D[i]) D[i] = D[i / 3] + 1;

		}

		System.out.println(D[N]);
	}

}

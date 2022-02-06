package 백트래킹;

import java.util.Scanner;

public class BOJ_15652_N과M4 {
	static int N;
	static int M;
	static int[] array;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		array = new int[M];

		dfs(0, -1);
		System.out.println(sb);

	}

	static void dfs(int depth ,int j) {
		if (depth == M) {
			for (int num : array) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (i>=j) {
				array[depth] = i + 1;
				dfs(depth + 1, i);
			}
		}

	}

}
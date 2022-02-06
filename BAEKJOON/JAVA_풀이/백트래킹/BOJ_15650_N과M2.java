package 백트래킹;

import java.util.Scanner;

public class BOJ_15650_N과M2 {
	static int N;
	static int M;
	static int[] array;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		array = new int[M];
		visited = new boolean[N];

		dfs(0, -1);

	}

	static void dfs(int depth ,int j) {
		if (depth == M) {
			for (int num : array) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && i>j) {
				visited[i] = true;
				array[depth] = i + 1;
				dfs(depth + 1, i);
				visited[i] = false;
			}
		}

	}

}
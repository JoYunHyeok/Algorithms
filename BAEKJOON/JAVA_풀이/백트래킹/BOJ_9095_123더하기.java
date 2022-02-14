package 백트래킹;

import java.util.Scanner;

public class BOJ_9095_123더하기 {
	static int TC, N, cnt;
	static int[] array = { 1, 2, 3 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		TC = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 0; tc < TC; tc++) {
			N = sc.nextInt();
			dfs(0);
			System.out.println(cnt);
			cnt = 0;
		}
	}

	static void dfs(int sum) {
		if (sum == N) {
			cnt++;
			return;
		}
		if (sum > N) {
			return;
		}

		for (int i = 0; i <= 2; i++) {
			dfs(sum + array[i]);
		}
	}
}

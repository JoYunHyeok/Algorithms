import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12581_숨바꼭질2 {
	static int[] dx = { -1, +1, 2 };
	static int N, K, cnt, fCnt, result;
	static boolean[] visited = new boolean[100001];
	static int[] map = new int[100001];
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt(); // 수빈이
		K = sc.nextInt(); // 동생

		q.offer(N);
		visited[N] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			visited[curr] = true;

			if (curr == K) {
				result = map[curr];
				fCnt += 1;
			}

			for (int i = 0; i < dx.length; i++) {
				int nextV = 0;
				if (i == 2)
					nextV = curr * dx[i];
				else
					nextV = curr + dx[i];

				if (nextV >= 0 && nextV < 100001) {
					if (!visited[nextV] || map[nextV] == map[curr] + 1) {
						visited[nextV] = true;
						q.offer(nextV);
						map[nextV] = map[curr] + 1;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(map));
		System.out.println(result);
		System.out.println(fCnt);
	}

}

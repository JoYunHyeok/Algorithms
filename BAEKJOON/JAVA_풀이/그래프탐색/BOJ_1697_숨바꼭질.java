import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	static int[] dx = { -1, +1, 2 };
	static int N, K, cnt;
	static boolean[] visited = new boolean[100001];
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 수빈이
		K = sc.nextInt(); // 동생

		q.offer(new int[] { N, 0 });
		visited[N] = true;
		while (!q.isEmpty()) {
			int currV = q.peek()[0];
			int currCnt = q.peek()[1];
			q.poll();
			visited[currV] = true;

			if (currV == K) {
				System.out.println(currCnt);
				break;
			}

			for (int i = 0; i < dx.length; i++) {
				int nextV = 0;
				if (i == 2)
					nextV = currV * dx[i];
				else
					nextV = currV + dx[i];

				if (nextV >= 0 && nextV < 100001 && !visited[nextV]) {
					visited[nextV] = true;
					q.offer(new int[] {nextV, currCnt+1});
				}
			}
		}

	}

}

//더 유용한 풀이
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질_세번째풀이 {
	static int[] dx = { -1, +1, 2 };
	static int N, K, cnt;
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
				System.out.println(map[curr]);
				break;
			}

			for (int i = 0; i < dx.length; i++) {
				int nextV = 0;
				if (i == 2)
					nextV = curr * dx[i];
				else
					nextV = curr + dx[i];

				if (nextV >= 0 && nextV < 100001) {
					if (!visited[nextV]) {
						visited[nextV] = true;
						q.offer(nextV);
						map[nextV] = map[curr] + 1; // 어차피 제일 가까운 곳에만 +1을 할테니
					}
				}
			}
		}

	}

}


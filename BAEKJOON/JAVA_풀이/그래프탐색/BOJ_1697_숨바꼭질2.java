import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질2 {
	static int[] dx = { -1, +1, 2 };
	static int N, K, cnt;
	static boolean[] visited = new boolean[100001];
	static Queue<Point> q = new LinkedList<>();

	static class Point{
		int v, cnt;
		Point(int v, int cnt){
			this.v = v;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 수빈이
		K = sc.nextInt(); // 동생

		q.offer(new Point(N, 0));
		visited[N] = true;
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			visited[curr.v] = true;

			if (curr.v == K) {
				System.out.println(curr.cnt);
				break;
			}

			for (int i = 0; i < dx.length; i++) {
				int nextV = 0;
				if (i == 2)
					nextV = curr.v * dx[i];
				else
					nextV = curr.v + dx[i];

				if (nextV >= 0 && nextV < 100001 && !visited[nextV]) {
					visited[nextV] = true;
					q.offer(new Point(nextV, curr.cnt+1));
				}
			}
		}

	}

}

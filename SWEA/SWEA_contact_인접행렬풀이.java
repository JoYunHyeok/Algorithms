package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_contact_인접행렬풀이 {
	static int TC = 10;
	static int[][] graph;
	static int ans;

	//dfs인 경우 주석풀기
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			graph = new int[101][101];
			for (int l = 0; l < len / 2; l++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;
			}

			visited = new boolean[101];
			bfs(start);

			System.out.printf("#%d %d \n", tc, ans);
		}

	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[101];

		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			int tmp = 0;
			
			for(int s=0; s<size; s++) {
				int curr = q.poll();
				tmp = Math.max(tmp, curr);
				for (int i = 1; i < 101; i++) {
					if (!visited[i] && graph[curr][i] == 1) {
						q.offer(i);
						visited[i] = true;
					}
				}
			}
			ans = tmp;
			
		}
	}
	

}

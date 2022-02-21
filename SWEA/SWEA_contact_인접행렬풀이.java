package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_contact_인접행렬풀이 {
	static int TC = 10;
	static int[][] graph;
	static List<int[]> list;

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

			list = new ArrayList<>();
			visited = new boolean[101];
			bfs(start, 0);
			
			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o1[1] - o2[1];
				}
			});

//			for (int[] i : list) {
//				System.out.println(i[0] + "," + i[1]);
//			}

			System.out.printf("#%d %d \n", tc, list.get(list.size() - 1)[0]);
		}

	}

	public static void bfs(int start, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[101];

		q.offer(new int[] { start, cnt });
		visited[start] = true;

		while (!q.isEmpty()) {
			int curr = q.peek()[0];
			int currCnt = q.peek()[1];
			q.poll();

			for (int i = 1; i < 101; i++) {
				if (!visited[i] && graph[curr][i] == 1) {
					q.offer(new int[] { i, currCnt + 1 });
					list.add(new int[] { i, currCnt + 1 });
					visited[i] = true;
				}
			}
		}
	}
	

}

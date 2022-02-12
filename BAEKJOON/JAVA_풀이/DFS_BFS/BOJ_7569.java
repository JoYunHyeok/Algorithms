package graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
	static int N, M, H;
	static int[] dz = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, 0, -1, 1 };
	static int[][][] graph;
	static Queue<int[]> q = new LinkedList<>();
	static boolean flag = false; // 토마토 검사

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이
		graph = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int tom = Integer.parseInt(st.nextToken());
					graph[h][i][j] = tom;
				}
			}
		} // 입력 종료

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(graph[h][i][j] == 1) q.offer(new int[] { h, i, j });
				}
			}
		}
		
		bfs();
		
		int max = -2;
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(graph[h][i][j] == 0) flag = true;
//					if(graph[h][i][j] > max) max = graph[h][i][j];
					max = Math.max(max, graph[h][i][j]);
				}
			}
		}
		if(flag) {
			System.out.println(-1);
		}else {
			if(max==1) System.out.println(0);
			else System.out.println(max-1);
		}

	}

	static void bfs() {
		
		while (!q.isEmpty()) {
			int z = q.peek()[0];
			int y = q.peek()[1];
			int x = q.peek()[2];
			q.poll();

			for (int l = 0; l < 6; l++) {
				int zz = z + dz[l];
				int yy = y + dy[l];
				int xx = x + dx[l];
				if (zz >= 0 && zz < H && yy >= 0 && yy < N && xx >= 0 && xx < M) {
					if (graph[zz][yy][xx] == 0) {
						graph[zz][yy][xx] = graph[z][y][x] + 1;
						q.offer(new int[] { zz, yy, xx });
					}
				}
			}
		}
	}
}

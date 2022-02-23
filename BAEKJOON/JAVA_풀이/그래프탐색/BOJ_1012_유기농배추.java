package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int TC, M, N, K;
	static int[][] graph;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Point{
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			graph = new int[N][M];
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[y][x] = 1;
			}
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(graph[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt + "\n");
			
		}
		System.out.println(sb);
	}
	
	static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		graph[i][j] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int yy = p.y + dy[d];
				int xx = p.x + dx[d];
				if(yy>=0 && xx>=0 && yy<N && xx<M) {
					if(graph[yy][xx]==1) {
						graph[yy][xx] = 0;
						q.offer(new Point(yy, xx));
					}
				}
			}
		}
	}

}

package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_4963_섬의개수 {
	static int W, H;
	static int[][] graph;
	static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static class Point{
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W==0 && H ==0) break;
			
			graph = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt=0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
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
			
			for(int d=0; d<8; d++) {
				int yy = p.y + dy[d];
				int xx = p.x + dx[d];
				if(yy>=0 && xx>=0 && yy<H && xx<W) {
					if(graph[yy][xx]==1) {
						graph[yy][xx] = 0;
						q.offer(new Point(yy, xx));
					}
				}
			}
		}
	}
}

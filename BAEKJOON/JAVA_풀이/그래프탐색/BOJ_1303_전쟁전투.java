package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁전투 {
	static int N, M, cnt, wCnt, bCnt; 
	static char[][] graph;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Warrior {
		int y, x;
		char col;
		Warrior(int y, int x, char col){
			this.y = y;
			this.x = x;
			this.col = col;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new char[M][N];
		visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			String str = br.readLine(); 
			for(int j=0; j<N; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt = 0;
					bfs(i,j, graph[i][j]);
					
					if(graph[i][j] == 'W') {
						wCnt += Math.pow(cnt, 2);
					}else if(graph[i][j] == 'B') {
						bCnt += Math.pow(cnt, 2);
					}
				}	
			}
		}
		System.out.println(wCnt +" "+ bCnt);
		
	}
	
	static void bfs(int i, int j, char v) {
		Queue<Warrior> q = new LinkedList<>();
		q.offer(new Warrior(i, j, v));
		visited[i][j] = true;
		cnt++;
		
		while(!q.isEmpty()) {
			Warrior war = q.poll();
			
			for(int d=0; d<4; d++) {
				int yy = war.y + dy[d];
				int xx = war.x + dx[d];
				if(yy>=0 && xx>=0 && yy<M && xx<N) {
					if(!visited[yy][xx] && graph[yy][xx] == v) {
						visited[yy][xx] = true;
						q.offer(new Warrior(yy, xx, v));
						cnt++;
					}
				}
			}
		}
	}
}

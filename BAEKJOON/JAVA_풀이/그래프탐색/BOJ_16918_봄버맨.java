package graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨 {
	static int R, C, N, cnt;
	static char[][] graph;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		graph = new char[R][C]; 
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		
		if(N==1) {
			resultShow();
		}else {
			search();
			for(int i=2; i<=N; i++) {
				if(i % 2 == 0) zero();
				else{
					bfs();
					search();
				}
			}
			resultShow();
		}
		
		
	}
	static void resultShow() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}
	}
	
	static void zero() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				graph[i][j] = 'O';
			}
		}
	}
	
	static void search() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(graph[i][j] == 'O') q.offer(new int[] {i, j});
			}
		}
	}
	
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			graph[y][x] = '.';
			
			for(int l=0; l<4; l++) {
				int yy = y + dy[l];
				int xx = x + dx[l];
				if(yy>=0 && yy<R && xx>=0 && xx<C) {
					graph[yy][xx] = '.';
				}
			}
		}
		
	}

}

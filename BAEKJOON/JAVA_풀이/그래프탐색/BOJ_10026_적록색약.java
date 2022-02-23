package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static int N, rCnt, gCnt, bCnt;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Color{
		int y, x;
		char col;
		Color(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		graph = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		
		
		for(int tc=0; tc<2; tc++) {
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						bfs(i, j, graph[i][j]);
						if(graph[i][j] == 'R') rCnt++;
						else if(graph[i][j] == 'G') gCnt++;
						else bCnt++;
					}
				}
			}
			sb.append(rCnt+gCnt+bCnt + " ");
			rCnt = gCnt = bCnt=0;
		}
		
		System.out.println(sb);
		
	}
	static void bfs(int i, int j, char col) {
		Queue<Color> q = new LinkedList<>();
		q.offer(new Color(i, j));
		visited[i][j] = true;
		if(graph[i][j] == 'G') graph[i][j] = 'R';
		
		while(!q.isEmpty()) {
			Color color = q.poll();
			
			for(int d=0; d<4; d++) {
				int y = color.y + dy[d];
				int x = color.x + dx[d];
				if(y>=0 && x>=0 && y<N && x<N) {
					if(!visited[y][x] && graph[y][x] == col) {
						visited[y][x] = true;
						q.offer(new Color(y, x));
						if(graph[y][x] == 'G') graph[y][x] = 'R';
					}
				}
			}
		}
	}

}

package day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C, max;
	static int[][] graph;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	static boolean[] visited = new boolean[26]; // 알파벳 갯수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		
		graph = new int[R][C];
		for(int r=0; r<R; r++) {
			String line = br.readLine();
			for(int c=0; c<C; c++) graph[r][c] = line.charAt(c) - 'A'; // 숫자로 변경 A-'A' = 0
		}
		
		dfs(0, 0, 0);
		System.out.println(max);
		
	}
	
	static void dfs(int y, int x, int cnt) {
		if(visited[graph[y][x]]) { //방문한적 있는 알파벳이라면
			max = Math.max(max, cnt);
			return;
			
		}// 방문한적 없는 알파벳이라면 계속 재귀 탐색
		
		visited[graph[y][x]] = true; // 방문하면 해당 알파벳 true처리
		for(int d=0; d<4; d++) {
			int yy = y + dy[d];
			int xx = x + dx[d];
			if(yy>=0 && xx>=0 && yy<R && xx<C) dfs(yy, xx, cnt+1);
		}
		visited[graph[y][x]] = false; // 재귀 갔다오면 해당 알파벳 false처리 
			
		
		
	}
	
	
	
}

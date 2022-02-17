package day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int R, C, cnt;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	static boolean flag; // 스택에 쌓여있는 재귀들을 처리해주기 위함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new char[R][C];
		visited = new boolean[R][C];
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				graph[r][c] = str.charAt(c);
			}
		}//그래프 담기
		
//		for(int r=0; r<R; r++) {
//			for(int c=0; c<C; c++) {
//				System.out.print(graph[r][c] +" ");
//			}
//			System.out.println();
//		}
		
		for(int i=0; i<R; i++) {
			flag = false;
			dfs(i, 0);
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int y, int x) {
		if(x==C-1) {
			flag = true;
			cnt++;
			return;
		}
		
		for(int d=0; d<3; d++) {
			int yy = y + dy[d];
			int xx = x + dx[d];
			if(yy>=0 && xx>=0 && yy<R && xx<C) {
				if(!visited[yy][xx] && graph[yy][xx] == '.') {
					visited[yy][xx] = true;
					dfs(yy, xx);
					if(flag) return;
				}
			}
		}//for종료
	}
	
}

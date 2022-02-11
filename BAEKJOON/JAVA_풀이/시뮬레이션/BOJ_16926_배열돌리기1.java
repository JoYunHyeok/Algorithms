package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	static int N, M, R, tmp, idx, depth;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] graph;
	static boolean[][] visited; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 배열 담기
		
		
		for(int r=0; r<R; r++) {//회전시작
			visited = new boolean[N][M];
		
			for(int i=0; i< Math.min(N, M)/2; i++){
				tmp = graph[depth][depth];
				dfs(depth, depth);
				idx = 0; // 하 우 상 좌
				depth++;
			}
			depth = 0;
			
		}// 회전종료
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}// 배열출력
		
	}
	static void dfs(int y, int x) {
		int pre = tmp; // 이전 값 저장
		
		while(idx<4) {
			int yy = y + dy[idx];
			int xx = x + dx[idx];
			
			if(yy>=0 && yy<N && xx>=0 && xx<M && !visited[yy][xx]) {
				tmp = graph[yy][xx];
				graph[yy][xx] = pre;
				visited[yy][xx] = true;
				dfs(yy, xx);
			}else {//만약, 범위내통과x 방문체크x
				idx++;
			}
		}
		
	}
}



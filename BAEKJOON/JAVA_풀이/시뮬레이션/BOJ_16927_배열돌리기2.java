package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927_배열돌리기2 {
	static int N, M, R;
	static int[] dy = {1, 0, -1, 0}; // 하우상좌
	static int[] dx = {0, 1, 0, -1};
	static int[][] graph;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 배열 담기
		
		
		// 1씩 전진하는게 아닌 입력받은 R만큼 전진시켜야한다.
		// n번째 테두리마다 다른 수로 전진을 해야하는데
		// 예제2를 예를 들면 첫번째 테두리는 한번에 7칸씩이동을, 두번째 안쪽테두리는 1칸씩 이동만 한다.
		//첫번쨰의 반복문 2*5 + 2*4 -4 = 14칸(겉테두리)
		//두번째의 반복문 2*3 + 2*2 -4 = 6칸(속테두리)
		int n=N, m=M;
		for(int i=0; i<Math.min(N, M)/2; i++) {
			rotate(i, 2*n + 2*m -4);
			n-=2;
			m-=2;
		}
		
		
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				sb.append(graph[i][j] + " ");
			}
			sb.append("\n");
		} // 배열출력
		System.out.println(sb);
	}
	
	static void rotate(int start, int len) {
		//rLen은 총 몇바퀴 돌아야되는지 예제입력2를 예를 들면 7, 1이 나온다. 
		// 즉, 첫번째 겉 테두리는 7번 회전을, 두번째 속 테두리는 1번만 회전하면 된다.
		int rLen = R%len; 

		for (int j = 0; j < rLen; j++) {// 사각형 내에서 몇번을 돌지
			int y = start;
			int x = start;
			int idx = 0;
			int pre = graph[start][start];
			int tmp = 0;
			
			while (idx < 4) {
				int yy = y + dy[idx];
				int xx = x + dx[idx];
				if (yy >= start && yy < N - start && xx >= start && xx < M - start) {
					tmp = graph[yy][xx];
					graph[yy][xx] = pre;
					pre = tmp;
					y = yy;
					x = xx;
				} else idx++;
			}
			
		}

	}
}

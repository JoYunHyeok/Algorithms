import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 키순서 {
	static int TC, N, M, tCnt, dCnt, resultCnt;
	static int[][] map;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine()); // 테스트케이스 수
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine()); // 학생들의 수
			M = Integer.parseInt(br.readLine()); // 비교 횟수
			
			map = new int[N][N];
			result = new int[N];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
			}// 인접행렬 입력받기
			
			
			// top count
			for(int start=0; start<N; start++) {
				tCnt = 0; 
				visited = new boolean[N];
				visited[start] = true;
				topSearch(start);
				result[start] += tCnt;
			}
			
			// down count
			for(int start=0; start<N; start++) {
				dCnt = 0; 
				visited = new boolean[N];
				visited[start] = true;
				downSearch(start);
				result[start] += dCnt;
			}
			
			
			for(int i=0; i<N; i++) {
				if(result[i] == N-1)
					resultCnt++;
			}
			
			System.out.println("#"+tc+" "+resultCnt);
			resultCnt = 0;
		}
		
	}
	
	static void topSearch(int start) {
		for(int i=0; i<N; i++) {
			if(!visited[i] && map[start][i] == 1) {
				tCnt++;
				visited[i] = true;
				topSearch(i);
			}
		}
	}
	
	static void downSearch(int start) {
		for(int i=0; i<N; i++) {
			if(!visited[i] && map[i][start] == 1) {
				dCnt++;
				visited[i] = true;
				downSearch(i);
			}
		}
	}
	
}

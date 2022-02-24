package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1681_해밀턴순환회로 {
	static int N;
	static boolean[] visited;
	static int[][] array;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		array = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true; // 첫번째 출발지점은 박아두고 시작하기! 
		dfs(0, 0);
		System.out.println(min);
	}
	
	static void dfs(int start, int distSum) {
		if(distSum > min) // 기존 min값보다 크다면 아래 조건문에 들어갈 필요가 없지
			return;
		
		if(visitCheck()) { 
			if(array[start][0] != 0) { // 다 방문하고 집에 올때도 이동비용이 0인 경우가 있네..
				distSum += array[start][0];
				min = Math.min(min, distSum);
			}
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(!visited[i] && array[start][i] != 0) { //이동을 못하는 경우(0일때)는 제외해야지..문제 좀 읽자
				visited[i] = true;
				dfs(i, distSum + array[start][i]);
				visited[i] = false;
			}
		}
	}
	
	static boolean visitCheck() { // visited 탐색
		for(int i=0; i<N; i++) {
			if(!visited[i])
				return false;
		}
		return true;
	}
}

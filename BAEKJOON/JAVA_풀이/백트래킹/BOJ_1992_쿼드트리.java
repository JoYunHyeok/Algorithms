package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static int N;
	static int[][] array;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for(int i=0; i< N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				array[i][j] = str.charAt(j)-'0';
			}
		}//배열담기
		
		dfs(0, 0, N, N);
		System.out.println(sb);
		
	}
	// 범위를 줄여나가면서 재귀! 
	// 8x8 -> 4x4(왼쪽위) 4x4(오른쪽위) 4x4(왼쪽아래) 4x4(오른쪽아래)
	// 4x4 -> 2x2(왼쪽위) 2x2(오른쪽위) 2x2(왼쪽아래) 2x2(오른쪽아래)
	// 2x2 -> 1x1(왼쪽위) 1x1(오른쪽위) 1x1(왼쪽아래) 1x1(오른쪽아래) <= 한칸부터 append 시작!
	
	static void dfs(int si, int sj, int ei, int ej) {
		//주어진 si,sj(시작인덱스)부터 ei,ej(끝인덱스)까지 압축이 가능한지 탐색 
		boolean flag = true;
		int tmp = array[si][sj];
		for(int i=si; i<ei; i++) {
			for(int j=sj; j<ej; j++) {
				if(tmp != array[i][j]) flag = false; 
			}
		}
		
		if(flag) {//압축 가능 
			sb.append(tmp);
		}else { //압축 불가능
			if(ei-si == 1) {//더 이상 쪼개질 수 없는 1x1칸의 경우 append해준다.
				if(array[si][sj] == 0) sb.append(0);
				else if(array[si][sj] == 1) sb.append(1);
				return;
			}
			
			int mi = (si+ei)/2; // y축 중간값 
			int mj = (sj+ej)/2; // x축 중간값
			
			sb.append('('); //시작 괄호 붙이기
			dfs(si, sj, mi, mj);
			dfs(si, mj, mi, ej);
			dfs(mi, sj, ei, mj);
			dfs(mi, mj, ei, ej);
			sb.append(')'); // 끝 괄호 붙이기
		}
		
	}

}

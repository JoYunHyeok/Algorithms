package day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
	static int N, wCnt, bCnt;
	static int[][] array;
	static int[] color = new int[2];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		array = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, N, N);
		for(int c : color) {
			System.out.println(c);
		}
	}
	
	static void dfs(int si, int sj, int ei, int ej) {
		boolean flag = true;
		int tmp = array[si][sj];
		for(int i=si; i<ei; i++) {
			for(int j=sj; j<ej; j++) {
				if(tmp != array[i][j]) flag = false; 
			}
		}
		if(flag) {
			color[tmp]++;
		}else {
			if(ei-si==1) {
				if(array[si][sj]==0) color[0]++;
				if(array[si][sj]==1) color[1]++;
				return;
			}
			
			int mi = (si+ei)/2;
			int mj = (sj+ej)/2;
			
			dfs(si, sj, mi, mj);
			dfs(si, mj, mi, ej);
			dfs(mi, sj, ei, mj);
			dfs(mi, mj, ei, ej);
		}
		
		
	}
}

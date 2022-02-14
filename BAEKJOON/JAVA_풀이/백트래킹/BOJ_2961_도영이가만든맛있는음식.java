package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int[] S;
	static int[] B;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, 1, 0);
		System.out.println(min);
		
		
	}
	static void dfs(int idx, int cnt, int s, int b) {
		if(idx == N) {
			if(cnt>=1) {
				min = Math.min(min, Math.abs(s-b));
			}
			return;
		}
		
		dfs(idx+1, cnt+1, s * S[idx], b+B[idx]);
		dfs(idx+1, cnt, s, b);
	}

}

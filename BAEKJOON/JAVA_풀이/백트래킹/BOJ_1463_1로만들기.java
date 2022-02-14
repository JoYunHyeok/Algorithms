package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
	static int N;
	static int cnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(0, N);
		System.out.println(cnt);
	}
	
	static void dfs(int idx, int num) {
		if(num==1) {
			cnt = Math.min(cnt, idx);
			return;
		}
		if(cnt<=idx)
			return;
		
		if(num%3==0) dfs(idx+1, num/3);
		if(num%2==0) dfs(idx+1, num/2);
		dfs(idx+1, num-1);
		
	}
}

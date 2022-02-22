package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_창용마을무리의개수 {
	static int TC;
	static int[] parent;
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) parent[bRoot] = aRoot;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			for(int i=1; i<=N; i++) {
				parent[i] = i;
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// ********마지막 부분 깔끔하게 할 수 없을까..**********
			for(int i=1; i<=N; i++) {
				parent[i] = find(i);
			}
			Arrays.sort(parent);
			
			int tmp = parent[1];
			int cnt = 1;
			
			for(int i=2; i<=N; i++) {
				if(tmp != parent[i]) {
					tmp = parent[i];
					cnt++;
				}
			}
			
			System.out.printf("#%d %d \n", tc, cnt);
		}
		
	}

}

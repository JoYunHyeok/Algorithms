package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_서로소집합 {
	static int TC;
	static int[] parent;
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			for(int i=1; i<=N; i++) {
				parent[i] = i;
			}
			
			sb= new StringBuilder();
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int option = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(option == 0) { //union
					union(a, b);
				}else { // find
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.print("#"+tc+" ");
			System.out.println(sb);
		}
	}

}

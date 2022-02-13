package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	static int N;
	static int[] array;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			array = new int[N];
			for(int i=0; i<N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			
			dfs(0, 0, "");
			System.out.println();
			
		}
	}
	static void dfs(int idx, int cnt, String str) {
		if(cnt == 6) {
			System.out.println(str);
			return;
		}

		if(idx >= N)
			return;
		
		dfs(idx+1, cnt+1, str + array[idx]+" "); // str += array[idx]+" " 로 하면 밑에 재귀에 그대로 들어가서 틀린다...
		dfs(idx+1, cnt, str);
	}
	
}

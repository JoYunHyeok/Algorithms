package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 {
	static int[] array = new int[9];
	static boolean[] visited = new boolean[9];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, 0, 0, "");
	}
	
	static void dfs(int idx, int cnt, int sum, String str) {
		if(cnt ==7) {
			if(sum == 100) System.out.println(str);
			return;
		}
		if(idx>=9)
			return;
		
		dfs(idx+1, cnt+1, sum+array[idx], str+array[idx] +"\n");
		dfs(idx+1, cnt, sum, str);
	}

}

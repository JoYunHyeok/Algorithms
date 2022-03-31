package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	static int[][] array;
	static int[][] D;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N];
		D = new int[N+1][N];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(array[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
		for(int i=1; i<=N; i++) {
			D[i][0] = array[i][0] + Math.min(D[i-1][1], D[i-1][2]);
			D[i][1] = array[i][1] + Math.min(D[i-1][0], D[i-1][2]);
			D[i][2] = array[i][2] + Math.min(D[i-1][0], D[i-1][1]);
		}
		System.out.println(Math.min(Math.min(D[N][0], D[N][1]), D[N][2]));
	}

}

package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_»öÁ¾ÀÌ {
	static int N;
	static int[][] graph = new int[100][100];;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if (graph[i][j] == 0) {
						graph[i][j] = 1;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}

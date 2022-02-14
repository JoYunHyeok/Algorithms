package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_규영이와인영이의카드게임 {
	static int TC, wCnt, lCnt;
	static boolean[] numArray;
	static int[] gyu;
	static int[] in;
	static boolean[] visited = new boolean[9];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());

			numArray = new boolean[19];
			gyu = new int[9];
			in = new int[9];

			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				gyu[i] = num;
				numArray[num] = true;
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!numArray[i]) {
					in[idx] = i;
					idx++;
				}
			}

			dfs(0, 0, 0);
			System.out.println("#" + tc + " " + wCnt + " " + lCnt);
			wCnt = 0;
			lCnt = 0;
		}

	}

	static void dfs(int idx, int gyuSum, int inSum) {
		if (idx == 9) {
			if (gyuSum > inSum) {
				wCnt++;
			} else if (gyuSum < inSum) {
				lCnt++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (gyu[idx] > in[i]) 
					dfs(idx + 1, gyuSum + gyu[idx] + in[i], inSum);
				else 
					dfs(idx + 1, gyuSum, inSum + gyu[idx] + in[i]);
				visited[i] = false;
			}
		}

	}
}

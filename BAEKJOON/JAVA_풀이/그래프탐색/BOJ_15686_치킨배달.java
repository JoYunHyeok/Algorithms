package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static List<Point> home = new ArrayList<>();
	static List<Point> chicken = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					home.add(new Point(i, j));
				} else if (num == 2) {
					chicken.add(new Point(i, j));
				}
			}
		} // 집과 치킨집 따로 리스트에 담기 종료
		
		visited = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.println(result);
	}

	static void dfs(int idx, int cnt) {
		if (idx == chicken.size()) { // 문제 좀 잘 읽자 진짜 개짜증나네
			if (cnt == M) { // 다풀고 뭐하는거야
				int dist = 0;
				for (int i = 0; i < home.size(); i++) {
					int htoc = Integer.MAX_VALUE;
					for (int j = 0; j <chicken.size(); j++) {
						if (visited[j]) {
							int hc = Math.abs(home.get(i).x - chicken.get(j).x)
									+ Math.abs(home.get(i).y - chicken.get(j).y);
							htoc = Math.min(htoc, hc);
						}
					}
					dist += htoc;
				} //거리비교for문
				result = Math.min(result, dist);
			} //cnt 조건
			return;
		}
		
		visited[idx] = true;
		dfs(idx + 1, cnt + 1);
		visited[idx] = false;
		dfs(idx + 1, cnt);
	}
	
}

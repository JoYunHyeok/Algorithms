package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_contact_인접리스트풀이 {
	static int TC = 10;
	static List<int[]> list;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	// dfs인 경우 주석풀기
	static boolean[] visited;
	
	static class Node{
		int v;
		Node link;
		
		public Node(int v, Node link) {
			this.v = v;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [v=" + v + ", link=" + link + "]";
		}
		
	}
	
	static Node[] nodeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			
			nodeList = new Node[101];
			
			for (int l = 0; l < len / 2; l++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodeList[from] = new Node(to, nodeList[from]);
			}

			list = new ArrayList<>();
			visited = new boolean[101];
			bfs(start, 0);

			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o1[1] - o2[1];
				}
			});

//			for (int[] i : list) {
//				System.out.println(i[0] + "," + i[1]);
//			}

			System.out.printf("#%d %d \n", tc, list.get(list.size() - 1)[0]);
		}

	}

	public static void bfs(int start, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[101];

		q.offer(new int[] { start, cnt });
		visited[start] = true;

		while (!q.isEmpty()) {
			int curr = q.peek()[0];
			int currCnt = q.peek()[1];
			q.poll();

			for (Node tmp = nodeList[curr]; tmp != null; tmp = tmp.link) {
				if (!visited[tmp.v]) {
					q.offer(new int[] { tmp.v, currCnt + 1 });
					list.add(new int[] { tmp.v, currCnt + 1 });
					visited[tmp.v] = true;
				}
			}
		}
	}

}

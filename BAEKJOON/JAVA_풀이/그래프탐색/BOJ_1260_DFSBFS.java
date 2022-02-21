package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFSBFS {
	static int N, M, start;
	static int[][] graph;
	static boolean[] dfsVistied;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		dfsVistied = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = 1;
			graph[to][from] = 1;
		}
		
		dfs(start);
		System.out.println();
		bfs(start);
		
	}
	static void dfs(int start) {
		dfsVistied[start] = true;
		System.out.print(start + " ");
		for(int i=1; i<N+1; i++) {
			if(!dfsVistied[i] && graph[start][i] == 1) {
				dfsVistied[i] = true;
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		q.offer(start);
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr+" ");
			for(int i=1; i<N+1; i++) {
				if(!visited[i] && graph[curr][i] == 1) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}

}

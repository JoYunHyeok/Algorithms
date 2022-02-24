package day0224;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class BOJ_1753_최단경로 {
	static class Vertex implements Comparable<Vertex>{
		int no; // 정점의 번호
		int minDist; // 출발지에서 자신으로의 최소비용
		public Vertex(int no, int minDist) {
			this.no = no;
			this.minDist = minDist;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return this.minDist - o.minDist;
		}
		
	}
	
	static int V, E, start;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<Vertex>[] list; 
	/*
	list[1] --> 줄줄이연결
	list[2] --> 줄줄이연결
	list[3] --> 줄줄이연결
	list[4] --> 줄줄이연결
	list[5] --> 줄줄이연결
	list[6] --> 줄줄이연결
	list[7] --> 줄줄이연결
	*/ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		dist = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }// 줄줄이 담기
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Vertex(to, weight));
		}
		
		
		Arrays.fill(dist, Integer.MAX_VALUE); // 모두 최댓값으로
		dist[start] = 0; // 단, 시작은 0으로 해야됨
		PriorityQueue<Vertex> q = new PriorityQueue<>(); // Vertex 클래스에 comparable 잊지않기 오름차순으로!
		q.offer(new Vertex(start, dist[start]));// 시작정점과 시작점정에서의 비용
		
		while(!q.isEmpty()) {
			// 단계1 : 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			Vertex curr = q.poll(); 
			if(visited[curr.no]) continue; 
			
			visited[curr.no] = true; // 방문처리해주기
			
			// 단계2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			for(int i=0; i<list[curr.no].size(); i++) { // 해당, 정점에 연결된 간선 개수만큼 돌아야함
				int no2 = list[curr.no].get(i).no; 
				int minDist2 = list[curr.no].get(i).minDist + curr.minDist;
				if(!visited[no2] && dist[no2] > minDist2) {
					dist[no2] = minDist2;
					q.offer(new Vertex(no2, dist[no2]));
				}
			}
			
		}
		
		for(int i =1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
		
		
	}

}

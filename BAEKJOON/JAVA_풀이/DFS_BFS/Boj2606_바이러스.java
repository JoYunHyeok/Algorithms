import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2606_바이러스 {
	static int[][] graph;
	static boolean[] check;
	static void bfs(int start) {
		// TODO Auto-generated method stub
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		check[start] = true;
		
		q.offer(start);
		while(!q.isEmpty()) {
			int x =  q.poll();
			
			for(int i = 1; i < graph.length; i++) {
				if(graph[x][i] == 1 && check[i] != true) {
					q.offer(i);
					check[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int comCnt = sc.nextInt();
		int n = sc.nextInt();
		graph = new int[comCnt+1][comCnt+1];
		check = new boolean[comCnt+1];
		
		for(int i=0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		bfs(1);
	}

	
}

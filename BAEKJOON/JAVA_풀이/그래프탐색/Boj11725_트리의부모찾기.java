import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj11725_트리의부모찾기 {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] parents;
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			
			for(int item : graph.get(parent)) {	
				parents[item] = parent;
				// https://codechacha.com/ko/java-collections-arraylist-remove/
				// remove메소드 특정 값 지우기
				graph.get(item).remove(Integer.valueOf(parent));
				q.offer(item);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		parents = new int[n+1];
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<n-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		bfs(1);
		
		for(int i=2; i<parents.length; i++) {
			System.out.println(parents[i]);
		}

	}

}

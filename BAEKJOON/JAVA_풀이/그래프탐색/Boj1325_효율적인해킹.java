import java.io.*;
import java.util.*;

public class Boj1325_효율적인해킹 {
	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] cnt;

	static void dfs(int n) {
		visited[n] = true;
		for(int index : graph[n]) {
			cnt[index]++;
			dfs(index);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = new int[N+1];
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		
		for(int i=1; i<= N; i++) {
			visited = new boolean[N+1];
			dfs(i);
		}
//		System.out.println(Arrays.toString(cnt));
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<N+1; i++) {
			if(cnt[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString().trim());
		
	}

}

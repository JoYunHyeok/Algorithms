import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2667_단지번호붙이기 {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int hCnt = 0;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Integer> cntList;
	
	static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		int cnt = 1;
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			
			for(int l=0; l<4; l++) {
				int yy = dy[l] + y;
				int xx = dx[l] + x;
				if(yy >= 0 && yy < N && xx >= 0 && xx <N) {
					if(!visited[yy][xx] && graph[yy][xx] == 1) {
						cnt++;
						q.offer(new int[] {yy, xx});
						visited[yy][xx] = true;
					}
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[N][N];
		visited = new boolean[N][N];
		
		String str;
		for(int i=0; i<N; i++) {
			str = sc.next();
			for(int j=0; j<N; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		cntList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					cntList.add(bfs(i,j));
				}
			}
		}
		
		System.out.println(cntList.size());
		Collections.sort(cntList);
		for(int cnt : cntList) {
			System.out.println(cnt);
		}
	}

}

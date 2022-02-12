import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178_미로탈출 {
	static int[][] graph;
	static boolean[][] check;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int M;
	static int N;
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		check[0][0] = true;
		
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			for(int l=0; l<4; l++) {
				int yy = y + dy[l];
				int xx = x + dx[l];
				if(yy>=0 && yy<N && xx>=0 && xx<M) {
					if(!check[yy][xx] && graph[yy][xx] == 1) {
						graph[yy][xx] = graph[y][x] + 1;
						check[y][x] = true;
						q.offer(new int[] {yy, xx});
					}
				}
			}//for문 종료
		}// while문 종료
		
	}//bfs 종료
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = bf.readLine();
			for(int j=0; j<M; j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs();
		System.out.println(graph[N-1][M-1]);

	}

}

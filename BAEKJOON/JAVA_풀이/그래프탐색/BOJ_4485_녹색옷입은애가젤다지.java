import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_³ì»ö¿ÊÀÔÀº¾Ö°¡Á©´ÙÁö {
	static int N, tc;
	
	static int[][] map; // ÀÔ·Â¹ÞÀº ¸Ê
	static int[][] rupeeMap; // ·çÇÇ ´©ÀûÇÏ´Â ¸Ê
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Point{
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			rupeeMap = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // ¸ÊÀÔ·Â¹Þ±â
			for(int i=0; i<N; i++) {
				Arrays.fill(rupeeMap[i], Integer.MAX_VALUE);
			}
			rupeeMap[0][0] = map[0][0];
			
			bfs();
			System.out.println("Problem " + (tc+1) + ": " + rupeeMap[N-1][N-1]);
			tc++;
		}
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			
			for(int d=0; d<4; d++) {
				int y = point.y + dy[d];
				int x = point.x + dx[d];
				if(y>=0 && y<N && x>=0 && x<N) {
					if(rupeeMap[y][x] > rupeeMap[point.y][point.x] + map[y][x]) {
						rupeeMap[y][x] = rupeeMap[point.y][point.x] + map[y][x];
						q.offer(new Point(y, x));
					}
				}
			}
			
			
		}
	}
}

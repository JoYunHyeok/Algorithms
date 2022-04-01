package day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};	
	
	static class Point{
		int y, x, horseCnt, cnt;
		Point(int y, int x, int horseCnt){
			this.y = y;
			this.x = x;
			this.horseCnt =horseCnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0; i<W; i++) {
//			for(int j=0; j<H; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(bfs());
		
	}
	static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0));
		visited[0][0][0] = true;
		int time=0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point point = q.poll();
				
				if(point.y==H-1 && point.x ==W-1) {
					return time;
				}
				
				for(int d=0; d<4; d++) {
					int y = point.y + dy[d];
					int x = point.x + dx[d];
					if(y>=0 && y<H && x>=0 && x<W ) {
						if(!visited[y][x][point.horseCnt] && map[y][x] == 0) {// 원숭이 걸음
							visited[y][x][point.horseCnt] = true;
							q.offer(new Point(y, x, point.horseCnt));
						}
					}
				}
				
				if(point.horseCnt < K) {
					for(int h=0; h<8; h++) {
						int y = point.y + hy[h];
						int x = point.x + hx[h];
						if(y>=0 && y<H && x>=0 && x<W ) {
							if(!visited[y][x][point.horseCnt+1] && map[y][x] == 0) {// 원숭이 걸음
								visited[y][x][point.horseCnt+1] = true;
								q.offer(new Point(y, x, point.horseCnt+1));
							}
						}
					}
				}
			}
			time++;
		}// end while
		return -1;
	}
}

package day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int R, C, preCnt, time, ans;
	static int[][] map;
	static boolean[][]	visited;
	static boolean flag = true;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static class Point {
		int y, x;
		Point(int y, int x){
			this.y = y;	
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//치즈 맵 담기
		
		
		while(flag) {
			visited = new boolean[R][C];
			preCnt = 0;
			bfs();
			if(preCnt!=0) // 0이 되기전 치즈의 갯수 담기
				ans = preCnt;
		}
		
		System.out.println(time-1);
		System.out.println(ans);
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		visited[0][0] = true;
		ArrayList<Point> cheese = new ArrayList<>();
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			
			for(int d=0; d<4; d++) {
				int y = point.y + dy[d];
				int x = point.x + dx[d];
				
				if(y>=0 && y<R && x>=0 && x<C && !visited[y][x]) {
					if(map[y][x] == 0) { //0이면 계속 탐색
						q.offer(new Point(y, x));
						visited[y][x] = true;
					}else { // 1(치즈)면 배열에 담고, 카운트
						cheese.add(new Point(y, x));
						visited[y][x] = true;
					}
				}
				
			}
		}
		
		preCnt = cheese.size();
		
		if(cheese.size() != 0) {
			for(Point p : cheese) 
				map[p.y][p.x] = 0;
		}else {
			flag = false;
		}
		
		time++;
		
	}
		
		
		
	

}

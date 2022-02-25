import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static int R, C, T, result;
	static ArrayList<Point> mList = new ArrayList<>(); // 먼지를 담을 리스트
	static ArrayList<Point> aList = new ArrayList<>(); // 공기청소기 좌표를 담을 리스트
	static int[] my = {-1, 1, 0, 0};
	static int[] mx = {0, 0, -1, 1}; // 먼지 델타
	static int[][] graph;
	static Queue<Point> q = new LinkedList<>();
	static int[] ay = {0, -1, 0, 1, 0, 1, 0, -1};
	static int[] ax = {1, 0, -1, 0, 1, 0, -1, 0}; // 공기청정기 상
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				int weight = Integer.parseInt(st.nextToken());
				graph[r][c] = weight;
				if(weight > 0)
					mList.add(new Point(r, c, weight));
				else if(weight < 0)
					aList.add(new Point(r, c, -1));
			}
		}
		
		
		for(int t=0; t<T; t++) {
			//먼지 담기 
			for(int i=0; i<mList.size(); i++) {
				int y = mList.get(i).y;
				int x = mList.get(i).x;
				if(graph[y][x] < 5) continue;
				int cnt = 0;
				for(int m=0; m<4; m++) {
					int yy = y + my[m];
					int xx = x + mx[m];
					if(yy>=0 && xx>=0 && yy<R && xx<C) {
						if(graph[yy][xx] >= 0) {
							q.offer(new Point(yy, xx, graph[y][x]/5)); 
							cnt++;
						}
					}
				}
				graph[y][x] = graph[y][x] - graph[y][x]/5 * cnt;
			}
			
			//먼지 확산시키기
			bfs();
			
			//공기청정기 돌리기
			clean();
			
			mList = new ArrayList<>(); // 변한 맵에 먼지들을 다시 넣어줘야한다.
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(graph[r][c] > 0)
						mList.add(new Point(r, c, graph[r][c]));
				}
			}

		}// 초
		
		print();
	}

	static class Point{
		int y, x, weight;
		Point(int y, int x, int weight){
			this.y = y;
			this.x = x;
			this.weight = weight;
		}
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Point point = q.poll();
			graph[point.y][point.x] += point.weight;
		}
	}
	
	static void clean() {
		for(int i=0; i<aList.size(); i++) {
			int y = aList.get(i).y;
			int x = aList.get(i).x + 1;
			int dir = 0;
			int len = 3;
			int tmp = graph[y][x];
			graph[y][x] = 0;
			if(i==1) {
				dir = 4;
				len = 7;
			}
			
			while(true) {
				if(y == aList.get(i).y && x == aList.get(i).x) {
					graph[aList.get(i).y][aList.get(i).x] = -1;
					break;
				}
				if(dir > len) break;
				
				int yy = y + ay[dir];
				int xx = x + ax[dir];
				if(yy>=0 && xx>=0 && yy<R && xx<C) {
					int btmp = graph[yy][xx];
					graph[yy][xx] = tmp;
					tmp = btmp;
					y = yy;
					x = xx;
				}else {
					dir++;
				}
			}
		
		}
	}
	
	static void print() {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(graph[r][c] > 0) {
					result += graph[r][c];
				}
			}
		}
		System.out.println(result);
	}
}

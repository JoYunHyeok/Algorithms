import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
	static int N, M, R, C, L;
	static int cnt = 1;
	static int[][] map;
	static boolean[][] visited;

	static class Point{
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			R = Integer.parseInt(st.nextToken()); // 맨홀 y좌표
			C = Integer.parseInt(st.nextToken()); // 맨홀 x좌표
			L = Integer.parseInt(st.nextToken()); // 소요된 시간
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 맵 입력 받기
			
			
			cnt = 1;// 초기화
			bfs();
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(R, C));
		visited[R][C] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point point = q.poll();
				
				if(L-1 == 0) return;
				
				// 터널 구조물 타입에 따른 델타 배열
				int shape = map[point.y][point.x];
				int[][] delta = makeShape(shape);
				
				for(int d=0; d<delta.length; d++) {
					int y = point.y + delta[d][0];
					int x = point.x + delta[d][1];
					if(y>=0 && x>=0 && y<N && x<M && !visited[y][x]) { // 범위 검사 && 방문체크
						if(check(delta[d][0], delta[d][1], map[point.y][point.x], map[y][x])) {
							q.offer(new Point(y, x));
							visited[y][x] = true;
							cnt++;
						}
					}
				}
				
			}// end for
			L--;
		}//end while
	}

	private static boolean check(int i, int j, int curr, int next) {
		if(curr == 1) { // 터널 구조물 타입 1인 경우
			if(i == -1 && j == 0) { // 상
				if(next == 1 || next == 2 || next == 5 || next == 6) return true;	
			}else if(i == 1 && j == 0) { // 하
				if(next == 1 || next == 2 || next == 4 || next == 7) return true;	
			}else if(i == 0 && j == -1) { // 좌
				if(next == 1 || next == 3 || next == 4 || next == 5) return true;	
			}else { // 우
				if(next == 1 || next == 3 || next == 6 || next == 7) return true;	
			}
		}else if(curr == 2) { // 터널 구조물 타입 2인 경우
			if(i == -1 && j == 0) {
				if(next == 1 || next == 2 || next == 5 || next == 6) return true;
			}else if(i == 1 && j == 0) {
				if(next == 1 || next == 2 || next == 4 || next == 7) return true;
			}
		}else if(curr == 3) { // 터널 구조물 타입 3인 경우
			if(i == 0 && j == -1) {
				if(next == 1 || next == 3 || next == 4 || next == 5) return true;
			}else if(i == 0 && j == 1) {
				if(next == 1 || next == 3 || next == 6 || next == 7) return true;
			}
		}else if(curr == 4) { // 터널 구조물 타입 4인 경우
			if(i == -1 && j == 0) {
				if(next == 1 || next == 2 || next == 5 || next == 6) return true;
			}else if(i == 0 && j == 1) {
				if(next == 1 || next == 3 || next == 6 || next == 7) return true;
			}
		}else if(curr == 5) { // 터널 구조물 타입 5인 경우
			if(i == 1 && j == 0) {
				if(next == 1 || next == 2 || next == 4 || next == 7) return true;
			}else if(i == 0 && j == 1) {
				if(next == 1 || next == 3 || next == 6 || next == 7) return true;
			}
		}else if(curr == 6) { // 터널 구조물 타입 6인 경우
			if(i == 1 && j == 0) {
				if(next == 1 || next == 2 || next == 4 || next == 7) return true;
			}else if(i == 0 && j == -1) {
				if(next == 1 || next == 3 || next == 4 || next == 5) return true;
			}
		}else if(curr == 7) { // 터널 구조물 타입 7인 경우
			if(i == -1 && j == 0) {
				if(next == 1 || next == 2 || next == 5 || next == 6) return true;
			}else if(i == 0 && j == -1) {
				if(next == 1 || next == 3 || next == 4 || next == 5) return true;
			}
		}
		
		return false;
	}

	private static int[][] makeShape(int shape) {
		if(shape == 1) {
			return new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우
		}else if(shape == 2) {
			return new int[][] {{-1,0}, {1,0}}; // 상하
		}else if(shape == 3) {
			return new int[][] {{0,-1}, {0,1}};// 좌우
		}else if(shape == 4) {
			return new int[][] {{-1,0}, {0,1}}; // 상,우
		}else if(shape == 5) {
			return new int[][] {{1,0}, {0,1}}; // 하, 우
		}else if(shape == 6) {
			return new int[][] {{1,0}, {0,-1}}; // 하, 좌
		}else {
			return new int[][] {{-1,0}, {0,-1}}; // 상, 좌
		}
	}

}

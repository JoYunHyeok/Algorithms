import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
	static int N, L, R, day;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(check()) {
			day++;
		}
		
		System.out.println(day);
		
	}
	
	private static boolean check() {
		boolean flag = false;
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && bfs(i, j)){
					flag = true;
				}
			}
		}
		return flag;
	}

	private static boolean bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> unionQ = new LinkedList<>();
		visited[i][j] = true;
		q.offer(new Point(i, j));
		unionQ.offer(new Point(i, j));
		int sum=map[i][j];
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int y = p.y + dy[d];
				int x = p.x + dx[d];
				if(y>=0 && x>=0 && y<N && x<N && !visited[y][x]) {
					int diff = Math.abs(map[p.y][p.x] - map[y][x]);
					if(diff >= L && diff <= R) {
						q.offer(new Point(y, x));
						unionQ.offer(new Point(y, x));
						visited[y][x] = true;
						sum += map[y][x];
					}
				}
			}
			
		}
		
		int num = sum / unionQ.size();
		if(unionQ.size()>1) {
			Move(unionQ, num);
			return true;
		}
		
		return false;
	}
	
	private static void Move(Queue<Point> q, int sum) {
		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.y][p.x] = sum;
		}
	}

	static class Point{
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}

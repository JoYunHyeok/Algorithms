import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static int N, ans, eatCnt;
	static int sharkSize = 2;
	static int[][] map;
	static Queue<Point> q = new LinkedList<>();
	final static int[] dy= {-1, 1, 0, 0};
	final static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = parse(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = parse(st.nextToken());
				if(map[i][j] == 9) {
					q.offer(new Point(i, j));
					map[i][j] = 0;
				}
			}
		}
		
		while(sharkFine());
		System.out.println(ans);
	}
	
	
	private static boolean sharkFine() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		int dist = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point point = q.poll();
				
				for(int d=0; d<4; d++) {
					int y = point.y + dy[d];
					int x = point.x + dx[d];
					if(y>=0 && x>=0 && y<N && x<N && !visited[y][x]) {//범위체크
						if(sharkSize > map[y][x] && map[y][x] != 0) { // 아기상어가 더 크면
							pq.offer(new Point(y, x));
						}
						if(sharkSize >= map[y][x]) { // 아기상어가 지나갈 수 있다면 
							q.offer(new Point(y, x));
						}
						visited[y][x] = true;
					}
				}
			}
			
			dist++;
			
			if(!pq.isEmpty()) {
				q = new LinkedList<>(); // 한마리라도 잡히면 초기화
				Point fish = pq.poll();
				map[fish.y][fish.x] = 0;
				q.offer(fish);
				pq = new PriorityQueue<>(); // 한 마리 뻇으니까 초기화
				ans+=dist; // 거리 누적
				
				if(sharkSize == ++eatCnt) {
					sharkSize++;
					eatCnt=0;
				}
				return true;
			}
			
		}
		
		return false;
	}


	private static int parse(String str) {
		return Integer.parseInt(str);
	}

	private static class Point implements Comparable<Point>{
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Point o) {
			if(this.y == o.y) {
				return this.x-o.x;
			}
			return this.y-o.y;
		}
	}
	
	
}

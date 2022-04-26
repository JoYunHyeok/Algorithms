import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {
	final static int N = 4;
	final static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	final static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[][][] map = new int[N][N][2]; // 물고기 맵
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j][0] = parse(st.nextToken());
				map[i][j][1] = parse(st.nextToken())-1;
			}
		}
		
		dfs(0, 0, map[0][0][0], map); // x(행), y(열), sum, map
		System.out.println(max);
		
	}
	

	private static void dfs(int x, int y, int sum, int[][][] fMap) {
		max = Math.max(max, sum);
		
		int[][][] cloneMap = fishMove(fMap, x, y);
		
		cloneMap[x][y][0] = 0; // 상어가 물고기 먹음
		int dir = cloneMap[x][y][1]; // 상어가 먹은 물고기의 방향
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		while(check(nx, ny)) {
			if(cloneMap[nx][ny][0] != 0) {
				int temp = cloneMap[nx][ny][0];
				cloneMap[nx][ny][0] = -1;
				dfs(nx, ny, sum+temp, cloneMap);
				cloneMap[nx][ny][0] = temp;
			}
			nx += dx[dir];
			ny += dy[dir];
			
		}
	}


	private static int[][][] fishMove(int[][][] fMap, int sx, int sy) {
		int[][][] arr = new int[N][N][2]; // 새 배열 생성
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<2; k++) {
					arr[i][j][k] = fMap[i][j][k];
				}
			}
		}// 깊은 복사
		
		arr[sx][sy][0] = -1; // 상어의 위치

		for(int s=1; s<=16; s++) {
			fishChange(arr, s);
		}
		
		return arr;
	}


	private static void fishChange(int[][][] arr, int s) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j][0] == s ) {
					for(int n=arr[i][j][1]; n<arr[i][j][1] + 8; n++) {
						int ni = i + dx[n%8];
						int nj = j + dy[n%8];
						
						if(check(ni, nj) && arr[ni][nj][0] != -1) {
							int temp = 0;
							temp = arr[ni][nj][0];
							arr[ni][nj][0] = arr[i][j][0];
							arr[i][j][0] = temp;
							
							arr[i][j][1] = arr[ni][nj][1];
							arr[ni][nj][1] = n%8;
							return; // 자리 바꿔줬으면 while 탈출
						}
					} // n for
				}
			}
		}
	}
	
	
	private static boolean check(int nx, int ny) {
		if(nx >= 0 && ny >= 0 && nx < N && ny < N)
			return true;
		return false;
	}

	
	private static int parse(String str) {
		return Integer.parseInt(str);
	}
	
}

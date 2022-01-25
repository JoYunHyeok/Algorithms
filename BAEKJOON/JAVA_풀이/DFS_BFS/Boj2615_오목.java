import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2615_오목 {

	static int[][] graph = new int[21][21];
	static int [][][] visited = new int[21][21][4];
	static int[] dy = {1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1};
	static int N = 21;

	static int dfs(int y, int x, int d, int color) {
		int yy = y + dy[d];
		int xx = x + dx[d];
		//범위
		if(graph[yy][xx] == color) {
			return visited[yy][xx][d] = dfs(yy, xx, d, color) + 1;
		}
		return 1;
	}
	
	public static String searchFive() {
		for(int j=1; j<=19; j++) {
			for(int i=1; i<=19; i++) {
				if(graph[i][j] != 0	) {
					for(int d=0; d<4; d++) {
						if(visited[i][j][d] == 0 && dfs(i, j, d, graph[i][j]) == 5) {
							return graph[i][j] + "\n" + i + " " + j + "\n";
						}
					}
				}
			}
		}
		return "0";
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int i=1; i<=19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=19; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(searchFive());
		
		
	
		
	}
}

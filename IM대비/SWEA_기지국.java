import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
1
9
XXXXXXXXX
XXXHXXXXX
XXHAHXXHX
XXHHXXXXX
XXXXXXXXX
XXAHHXXXX
XXHXXHAHX
XXAHXXHXX
XXHXHXXXX
*/

public class SWEA_기지국 {
	static int TC;
	static char[][] graph;
	static int N;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			graph = new char[N][N];
			for(int i=0; i<N; i++) {
				graph[i] = br.readLine().toCharArray();
			}
		} // 주어진 맵 입력받기
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 'A' || graph[i][j] == 'B' || graph[i][j] == 'C') {
					int cnt = graph[i][j] - 65 + 1;
					
					for(int c=1; c<=cnt; c++) {
						for(int d=0; d<4; d++) {
							int y = i + dy[d] * c;
							int x = j + dx[d] * c;
							if(y>=0 && x>=0 && y<N && x<N) {
								if(graph[y][x] == 'H') {
									graph[y][x] = 'X';
								}
							}
						}
					}//탐색 for문 종료
					
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 'H') {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}

}

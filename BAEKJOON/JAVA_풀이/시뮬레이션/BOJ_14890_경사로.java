import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	static int N, L, ans;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = parse(st.nextToken());
		L = parse(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = parse(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			dfs(map[i], 0, 1); // 행 검사
			
			int[] arr = new int[N]; // 열 일차원 배열로 만들어주기
			for(int j=0; j<N; j++) {
				arr[j] = map[j][i];
			}
			dfs(arr, 0, 1); // 열 검사
			
		}
		System.out.println(ans);
	}
	
	private static void dfs(int[] arr, int idx, int cnt) {
		if(idx == N-1) {
			ans++;
			return;
		}
		
		if(idx >= N) {
			return;
		}
		
		if(arr[idx] == arr[idx+1]) { // 평지
			dfs(arr, idx+1, cnt+1);
		}
		if(arr[idx] - arr[idx+1] == -1 && cnt >= L) { // 오르막
			dfs(arr, idx+1, 1);
		}
		if(arr[idx] - arr[idx+1] == 1 ) { // 내리막
			if(idx+L < N && check(arr, idx)) { // 내리막 갈 수 있는지 여부 체크하는 함수
				dfs(arr, idx+L, 0);
			}
		}
		
	}

	private static boolean check(int[] arr, int idx) {
		int temp = arr[idx]-1; // 한칸 아래
		for(int l=1; l<=L; l++) {
			if(arr[idx+l] != temp) return false;
		}
		return true;
	}
	

	private static int parse(String str) {
		return Integer.parseInt(str);
	}

}

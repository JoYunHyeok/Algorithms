import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_���� {
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
			dfs(map[i], 0, 1); // �� �˻�
			
			int[] arr = new int[N]; // �� ������ �迭�� ������ֱ�
			for(int j=0; j<N; j++) {
				arr[j] = map[j][i];
			}
			dfs(arr, 0, 1); // �� �˻�
			
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
		
		if(arr[idx] == arr[idx+1]) { // ����
			dfs(arr, idx+1, cnt+1);
		}
		if(arr[idx] - arr[idx+1] == -1 && cnt >= L) { // ������
			dfs(arr, idx+1, 1);
		}
		if(arr[idx] - arr[idx+1] == 1 ) { // ������
			if(idx+L < N && check(arr, idx)) { // ������ �� �� �ִ��� ���� üũ�ϴ� �Լ�
				dfs(arr, idx+L, 0);
			}
		}
		
	}

	private static boolean check(int[] arr, int idx) {
		int temp = arr[idx]-1; // ��ĭ �Ʒ�
		for(int l=1; l<=L; l++) {
			if(arr[idx+l] != temp) return false;
		}
		return true;
	}
	

	private static int parse(String str) {
		return Integer.parseInt(str);
	}

}

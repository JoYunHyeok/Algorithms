import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
	static int[] array;
	static int N, M, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		array = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0);
		System.out.println(max);
		
	}
	static void dfs(int idx, int cnt, int sum) {
		if(cnt == 3) {
			if(sum <= M) max = Math.max(max, sum);
			return;
		}
		
		if(idx >= N)
			return;
		
		dfs(idx+1, cnt+1, sum + array[idx]);
		dfs(idx+1, cnt, sum);
	}

}

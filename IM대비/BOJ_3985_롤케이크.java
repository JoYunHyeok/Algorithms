import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3985_롤케이크 {
	static int[] array;
	static int[] result;
	static int L, N, ans;
	static int max=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		L = Integer.parseInt(br.readLine()); // 롤케익 길이
		N = Integer.parseInt(br.readLine()); // 방청객의 수
		
		array = new int[L+1];
		result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			max = Math.max(max, to-from+1);
			result[i] = to-from+1;
			
			for(int j=from; j<=to; j++) {
				if(array[j] != 0) 
					continue;
				array[j] = i;
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(max == result[i]) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		
		// 바뀐 array로 
		ans = 0;
		result = new int[N+1];
		max=0;
		for(int i=1; i<=L; i++) {
			result[array[i]]++;
		}
		
		for(int i=1; i<=N; i++) {
			max = Math.max(max, result[i]);
		}
		for(int i=1; i<=N; i++) {
			if(max == result[i]) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		
	}

}

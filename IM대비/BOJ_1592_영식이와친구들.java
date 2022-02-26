import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1592_영식이와친구들 {
	static int N, M, L, idx, cnt;
	static int[] array;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		array = new int[N];
		array[0] = 1;
		
		while(true) {
			if(array[idx] == M) {
				System.out.println(cnt);
				break;
			}
			
			if(array[idx] % 2 != 0) {
				if(idx+L > N-1) 
					idx = (idx + L)%N;
				else
					idx+=L;
				array[idx]++;
				cnt++;
				
			}else {//만약 짝수라면
				if(idx-L < 0) 
					idx = N + (idx-L);
				else
					idx -= L;
				array[idx]++;
				cnt++;
			}
			
		}
		
	}

}

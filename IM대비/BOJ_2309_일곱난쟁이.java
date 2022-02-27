import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	static int[] array;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		array = new int[9];
		for(int i=0; i<9; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		dfs(0, 0, "", 0);
		
	}
	
	static void dfs(int idx, int cnt, String str, int sum) {
		if(flag)
			return;
		
		if(cnt == 7) {
			if(sum == 100) {
				System.out.println(str);
				flag = true;
			}
			return;
		}

		if(idx>=9)
			return;
		
		dfs(idx+1, cnt+1, str+array[idx]+"\n", sum + array[idx]);
		dfs(idx+1, cnt, str, sum);
		
	}

}

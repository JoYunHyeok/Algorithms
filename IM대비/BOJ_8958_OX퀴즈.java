import java.util.Scanner;

public class BOJ_8958_OX퀴즈 {
	static int N, result, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			String str = sc.next();
			cnt = result = 0;
			for(int s=0; s<str.length(); s++) {
				if(str.charAt(s) == 'X') cnt =0;
				else cnt++;
				result += cnt;
			}
			System.out.println(result);
		}
		
		
	}

}

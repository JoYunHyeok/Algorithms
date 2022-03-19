package 백준수학;

import java.util.Scanner;

public class BOJ_2003_조합0의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int cntFive = five(n) - five(n-m) - five(m);
		int cntTwo = two(n) - two(n-m) - two(m);
		
		System.out.println(Math.min(cntFive, cntTwo));
		
	}
	static int five(int num) {
		int cnt=0;
		while(num >= 5) {
			cnt += num/5;
			num /= 5;
		}
		return cnt;
	}
	
	static int two(int num) {
		int cnt=0;
		while(num >= 2) {
			cnt += num/2;
			num /= 2;
		}
		return cnt;
	}

}

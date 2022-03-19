package 백준수학;

import java.util.Scanner;

public class BOJ_1929_소수구하기_에라토스테네스의체 {
	static int size = 1000001;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		visited = new boolean[size];
		visited[1] = true;
		
		for(int i=2; i<=N; i++) {
			for(int j=2; i*j<=N; j++) {
				visited[i*j] = true;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(!visited[i]) System.out.println(i);
		}
	}
	
	
}

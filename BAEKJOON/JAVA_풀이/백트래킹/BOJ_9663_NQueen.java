package day0217;

import java.util.Scanner;

public class BOJ_9663_NQueen {
	static int N, cnt;
	static int[] row;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		row = new int[N]; // N크기의 행에 퀸이 놓여진 열을 저장하는 1차원 배열
		
		dfs(0);
		System.out.println(cnt); 
	}
	static void dfs(int q) {
		if(q==N) {
			cnt++; //놓여질 수 있는 경우 카운트
			return;
		}
		if(q>N) // 주어진 행을 초과하면 return
			return;
		
		for(int i=0; i<N; i++) { // 놓여질 퀸의 열 반복문
			row[q] = i; // 현재 행에 퀸이 놓여질 열을 저장한다..
			if(check(q)) { // 가지치기
				dfs(q+1);				
			}
		}
	}
	
	static boolean check(int q) {
		// 수직이 같다면 false
		// 대각선검사, 이떄 q-i와 비교를 해야한다. 단순히 1을 하면 안된다.
		// q-i로 현재 체스의 위치와 이전의 체스의 위치를 비교해야한다.
		for(int i=0; i<q; i++) {//0행부터 현재 행까지
			if(row[q] == row[i] || Math.abs(row[q] - row[i]) == q-i) return false; 
		}
		return true;
	}
}

package day0220;

import java.util.Arrays;
import java.util.Scanner;
/*
예제입력
5 8 3
2 4 5 4 6
*/

public class Main_큰수의법칙 {
	static int N, M, K, result;
	static int[] array;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt();
		K = sc.nextInt();
		
		array = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array); // 정렬
		
		int first = array[N-1]; // 배열에서 제일 높은 수
		int second = array[N-2]; // 두번째로 높은 수
		
		while(true) { //M이 0이 될 때까지
			for(int i=0; i<K; i++) { //K번 동안 제일 높은 수 더해주기
				if(M==0) break; // M이 0이면 for문 탈출
				result += first; 
				M--;
			}
			if(M==0) break; // M이 0이면 while문 탈출
			result += second; // 두번째로 높은 수는 한번만 더해준다.
			M--;
		}
		
		System.out.println(result);
		
	}

}

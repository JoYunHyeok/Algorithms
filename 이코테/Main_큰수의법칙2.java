package day0220;

import java.util.Arrays;
import java.util.Scanner;

public class Main_큰수의법칙2 {
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
		
		int first = array[N-1];
		int second = array[N-2];
		
		int count = (M/(K+1)) * K + M % (K+1);
		result += count * first;
		result += (M-count) * second;
		System.out.println(result);
		
	}
}

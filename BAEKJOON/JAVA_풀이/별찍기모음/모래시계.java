package ��������;

import java.util.Scanner;

public class �𷡽ð� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0, j=0; i<num; i++) {
			for(int k=0; k<num-j; k++) {
				if(k<j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}//2for
			if(i<num/2) {
				j++;
			}else {
				j--;
			}
			System.out.println();
			
		}//1for
	}

}

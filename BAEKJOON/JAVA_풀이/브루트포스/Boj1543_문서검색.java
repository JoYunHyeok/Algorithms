package ���ڿ�;

import java.util.Scanner;

public class Boj1543_�����˻� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String s = sc.nextLine();
		
		int cnt = 0;
		
		for(int i=0; i <= str.length()-s.length(); i++) {
			if(str.substring(i, i+s.length()).equals(s)) {
				cnt++;
				i+=s.length()-1;
			}
		}

		System.out.println(cnt);
	}

}

package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		int len = str.length();
		int sqrt = (int)Math.sqrt(str.length());
		int r = 0;
		int c = 0;
		for (int i = 1; i <= sqrt; i++) {
			if (len % i == 0) {
				r = i;
				c = len / i;
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(str.charAt(i + (j * r)));
			}
		}

		System.out.println(sb);
		
	}

}

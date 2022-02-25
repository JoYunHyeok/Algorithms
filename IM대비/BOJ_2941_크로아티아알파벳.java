import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_2941_크로아티아알파벳 {
	static int dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		
		for(int i=0; i<str.length(); i++) {
			char s = str.charAt(i);
			
			
			if(s == 'c' && i < len-1) {
				if(str.charAt(i+1) == '=' || str.charAt(i+1) == '-') {
					i++;
				}
			}// c= c-
			
			if(s == 'd' && i < len-1) {
				if(str.charAt(i+1) == '-') {
					i++;
				}else if(str.charAt(i+1) == 'z' && i<len-2) {
					if(str.charAt(i+2) == '=') 
						i+=2;
				}
			} //d- dz=
			
			if(i<len-1) {
				if(str.charAt(i+1) == 'j' ) {
					if(s == 'l' || s== 'n') i++;
				}
			}
			
			if(i<len-1) {
				if(str.charAt(i+1) == '=') {
					if(s == 's' || s== 'z') i++;
				}
			}
			
			
			dist++;
			
		}
		System.out.println(dist);
	}

}

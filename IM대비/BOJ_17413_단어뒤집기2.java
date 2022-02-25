import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		boolean flag = false;
		
		for(int i=0; i < str.length(); i++) {
			char s = str.charAt(i);
			
			if(s == '<') {
				while(!stack.isEmpty()) 
					sb.append(stack.pop());
				flag = true;
			}
			
			else if(s == '>') {
				flag = false;
				sb.append(s);
				continue;
			}
			
			if(flag) {
				sb.append(s);
			}else {
				if(s == ' ') {
					while(!stack.isEmpty()) 
						sb.append(stack.pop());
					sb.append(s);
				}else {
					stack.push(s);
				}
			}
			
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}

}

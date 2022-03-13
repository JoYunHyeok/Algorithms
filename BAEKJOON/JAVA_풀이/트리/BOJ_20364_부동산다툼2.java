import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20364_부동산다툼2 {
	static int Q, N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = stoi(st.nextToken());
		int Q = stoi(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		
		while(Q-- > 0) {
			int duck = stoi(br.readLine()); // 오리가 점유하려는 땅
			int tmp = duck;
			int ground = 0;
			
			while(tmp >1) { // tmp가 0이 될떄까지
				if(visited[tmp]) ground = tmp;
				tmp/=2;
			}
			
			if(ground == 0) { // 오리가 점유하고 싶은 땅을 방문처리
				visited[duck] = true;
			}
			sb.append(ground + "\n"); // 이때 만약 ground가 0이 아닌 경우는 중간에 이미 점유가 된 땅
			
		}
		System.out.println(sb);
		
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}



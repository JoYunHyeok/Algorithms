import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {
	static int n, m;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(check == 1) {
				if(find(a) == find(b)) 
					System.out.println("YES");
				else
					System.out.println("NO");
			}else {
				union(a, b);
			}
			
		}
	}
	
	static int find(int x) {
		if(x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b)
			parents[b] = a;
		else
			parents[a] = b;
	}

}

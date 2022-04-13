import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15662_톱니바퀴2 {
	static int N, ans; // 톱니바퀴의 수
	static LinkedList<LinkedList<Integer>> list;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new LinkedList<>();
		for(int i=0; i<N; i++) {
			list.add(new LinkedList<>());
			String str = sc.next();
			for(int s=0; s<str.length(); s++) {
				list.get(i).add(str.charAt(s)-'0');
			}
		}
		
		
		int TC = sc.nextInt(); // 회전 수
		for(int tc=0; tc<TC; tc++) {
			int num = sc.nextInt()-1; // 톱니바퀴 번호
			int dir = sc.nextInt(); // 방향
			
			visited = new boolean[N];
			dfs(num, dir);
		}
		
		for(List li : list) {
			if((int)li.get(0) == 1) ans++;
		}
		System.out.println(ans);

		
	}
	
	static void dfs(int num, int dir) {
		visited[num] = true;
		
		int left = list.get(num).get(2);
		int right = list.get(num).get(6);
		
		if(dir == 1) { // 시계방향
			list.get(num).addFirst(list.get(num).removeLast());
		}else { // 반시계방향
			list.get(num).addLast(list.get(num).removeFirst());
		}
		
		
		if(num-1>=0 && !visited[num-1] && right != list.get(num-1).get(2)) {
			dfs(num-1, -dir);
			
		}
		if(num+1<N && !visited[num+1] && left != list.get(num+1).get(6)) {
			dfs(num+1, -dir);
		}
		
	}

}

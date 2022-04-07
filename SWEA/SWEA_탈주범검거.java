import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ż�ֹ��˰� {
	static int N, M, R, C, L;
	static int cnt = 1;
	static int[][] map;
	static boolean[][] visited;

	static class Point{
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // ����
			M = Integer.parseInt(st.nextToken()); // ����
			R = Integer.parseInt(st.nextToken()); // ��Ȧ y��ǥ
			C = Integer.parseInt(st.nextToken()); // ��Ȧ x��ǥ
			L = Integer.parseInt(st.nextToken()); // �ҿ�� �ð�
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// �� �Է� �ޱ�
			
			
			cnt = 1;// �ʱ�ȭ
			bfs();
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(R, C));
		visited[R][C] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point point = q.poll();
				
				if(L-1 == 0) return;
				
				// �ͳ� ������ Ÿ�Կ� ���� ��Ÿ �迭
				int shape = map[point.y][point.x];
				int[][] delta = makeShape(shape);
				
				for(int d=0; d<delta.length; d++) {
					int y = point.y + delta[d][0];
					int x = point.x + delta[d][1];
					if(y>=0 && x>=0 && y<N && x<M && !visited[y][x]) { // ���� �˻� && �湮üũ
						if(check(delta[d][0], delta[d][1], map[point.y][point.x], map[y][x])) {
							q.offer(new Point(y, x));
							visited[y][x] = true;
							cnt++;
						}
					}
				}
				
			}// end for
			L--;
		}//end while
	}

	private static boolean check(int i, int j, int curr, int next) {
		if(curr == 1) { // �ͳ� ������ Ÿ�� 1�� ���
			if(i == -1 && j == 0) { // ��
				if(next == 1 || next == 2 || next == 5 || next == 6) return true;	
			}else if(i == 1 && j == 0) { // ��
				if(next == 1 || next == 2 || next == 4 || next == 7) return true;	
			}else if(i == 0 && j == -1) { // ��
				if(next == 1 || next == 3 || next == 4 || next == 5) return true;	
			}else { // ��
				if(next == 1 || next == 3 || next == 6 || next == 7) return true;	
			}
		}else if(curr == 2) { // �ͳ� ������ Ÿ�� 2�� ���
			if(i == -1 && j == 0) {
				if(next == 1 || next == 2 || next == 5 || next == 6) return true;
			}else if(i == 1 && j == 0) {
				if(next == 1 || next == 2 || next == 4 || next == 7) return true;
			}
		}else if(curr == 3) { // �ͳ� ������ Ÿ�� 3�� ���
			if(i == 0 && j == -1) {
				if(next == 1 || next == 3 || next == 4 || next == 5) return true;
			}else if(i == 0 && j == 1) {
				if(next == 1 || next == 3 || next == 6 || next == 7) return true;
			}
		}else if(curr == 4) { // �ͳ� ������ Ÿ�� 4�� ���
			if(i == -1 && j == 0) {
				if(next == 1 || next == 2 || next == 5 || next == 6) return true;
			}else if(i == 0 && j == 1) {
				if(next == 1 || next == 3 || next == 6 || next == 7) return true;
			}
		}else if(curr == 5) { // �ͳ� ������ Ÿ�� 5�� ���
			if(i == 1 && j == 0) {
				if(next == 1 || next == 2 || next == 4 || next == 7) return true;
			}else if(i == 0 && j == 1) {
				if(next == 1 || next == 3 || next == 6 || next == 7) return true;
			}
		}else if(curr == 6) { // �ͳ� ������ Ÿ�� 6�� ���
			if(i == 1 && j == 0) {
				if(next == 1 || next == 2 || next == 4 || next == 7) return true;
			}else if(i == 0 && j == -1) {
				if(next == 1 || next == 3 || next == 4 || next == 5) return true;
			}
		}else if(curr == 7) { // �ͳ� ������ Ÿ�� 7�� ���
			if(i == -1 && j == 0) {
				if(next == 1 || next == 2 || next == 5 || next == 6) return true;
			}else if(i == 0 && j == -1) {
				if(next == 1 || next == 3 || next == 4 || next == 5) return true;
			}
		}
		
		return false;
	}

	private static int[][] makeShape(int shape) {
		if(shape == 1) {
			return new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}}; // �����¿�
		}else if(shape == 2) {
			return new int[][] {{-1,0}, {1,0}}; // ����
		}else if(shape == 3) {
			return new int[][] {{0,-1}, {0,1}};// �¿�
		}else if(shape == 4) {
			return new int[][] {{-1,0}, {0,1}}; // ��,��
		}else if(shape == 5) {
			return new int[][] {{1,0}, {0,1}}; // ��, ��
		}else if(shape == 6) {
			return new int[][] {{1,0}, {0,-1}}; // ��, ��
		}else {
			return new int[][] {{-1,0}, {0,-1}}; // ��, ��
		}
	}

}

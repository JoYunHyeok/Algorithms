package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927_�迭������2 {
	static int N, M, R;
	static int[] dy = {1, 0, -1, 0}; // �Ͽ����
	static int[] dx = {0, 1, 0, -1};
	static int[][] graph;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		} // �迭 ���
		
		
		// 1�� �����ϴ°� �ƴ� �Է¹��� R��ŭ �������Ѿ��Ѵ�.
		// n��° �׵θ����� �ٸ� ���� ������ �ؾ��ϴµ�
		// ����2�� ���� ��� ù��° �׵θ��� �ѹ��� 7ĭ���̵���, �ι�° �����׵θ��� 1ĭ�� �̵��� �Ѵ�.
		//ù������ �ݺ��� 2*5 + 2*4 -4 = 14ĭ(���׵θ�)
		//�ι�°�� �ݺ��� 2*3 + 2*2 -4 = 6ĭ(���׵θ�)
		int n=N, m=M;
		for(int i=0; i<Math.min(N, M)/2; i++) {
			rotate(i, 2*n + 2*m -4);
			n-=2;
			m-=2;
		}
		
		
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				sb.append(graph[i][j] + " ");
			}
			sb.append("\n");
		} // �迭���
		System.out.println(sb);
	}
	
	static void rotate(int start, int len) {
		//rLen�� �� ����� ���ƾߵǴ��� �����Է�2�� ���� ��� 7, 1�� ���´�. 
		// ��, ù��° �� �׵θ��� 7�� ȸ����, �ι�° �� �׵θ��� 1���� ȸ���ϸ� �ȴ�.
		int rLen = R%len; 

		for (int j = 0; j < rLen; j++) {// �簢�� ������ ����� ����
			int y = start;
			int x = start;
			int idx = 0;
			int pre = graph[start][start];
			int tmp = 0;
			
			while (idx < 4) {
				int yy = y + dy[idx];
				int xx = x + dx[idx];
				if (yy >= start && yy < N - start && xx >= start && xx < M - start) {
					tmp = graph[yy][xx];
					graph[yy][xx] = pre;
					pre = tmp;
					y = yy;
					x = xx;
				} else idx++;
			}
			
		}

	}
}

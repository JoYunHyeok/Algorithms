package graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {
	static int N, M, R, K;
	static int[][] graph;
	static int[][] upGraph;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		upGraph = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int rr = 0; rr < R; rr++) {
			K = Integer.parseInt(st.nextToken());
			
			if (K == 1) { // 상하반전
				for(int c=0; c<graph[0].length; c++) {
					for(int r1=0, r2=graph.length -1; r1<r2; r1++, r2--) {
						int temp = graph[r1][c];
						graph[r1][c] = graph[r2][c];
						graph[r2][c] = temp;
					}
				}
			
			} else if (K == 2) { // 좌우반전
				for(int r=0; r<graph.length; r++) {
					for(int c1=0, c2=graph[0].length-1; c1<c2; c1++,c2--) {
						int temp = graph[r][c1];
						graph[r][c1] = graph[r][c2];
						graph[r][c2] = temp;
					}
				}
			} else if (K == 3) { // 오른쪽 90도
				int[][] result = new int[graph[0].length][graph.length];

				for (int i = 0; i < graph.length; i++) {
					for (int j = 0; j < graph[0].length; j++) {
						result[j][graph.length - 1 - i] = graph[i][j];
					}
				}
				graph = result;

			} else if (K == 4) { // 왼쪽 90도
				int[][] result = new int[graph[0].length][graph.length];

				for (int i = 0; i < graph.length; i++) {
					for (int j = 0; j < graph[0].length; j++) {
						result[graph[0].length - 1 - j][i] = graph[i][j];
					}
				}
				graph = result;

			} else if (K == 5) { // 그룹나누고 오른쪽 방향으로
				int[][] result = new int[graph.length][graph[0].length];
				int r = graph.length; // 3,4 실행시 r,c가 달라지니까 무조건..
				int c = graph[0].length;
				
				// 1 -> 2
				for (int i = 0; i < r / 2; i++) {
					for (int j = 0; j < c / 2; j++) {
						result[i][(c / 2) + j] = graph[i][j];
					}
				}
				// 2 -> 3
				for (int i = 0; i < r / 2; i++) {
					for (int j = c / 2; j < c; j++) {
						result[(r / 2) + i][j] = graph[i][j];
					}
				}
				// 3 -> 4
				for (int i = r / 2; i < r; i++) {
					for (int j = c / 2; j < c; j++) {
						result[i][j - (c / 2)] = graph[i][j];
					}
				}
				// 4 -> 1
				for (int i = r / 2; i < r; i++) {
					for (int j = 0; j < c / 2; j++) {
						result[i - (r / 2)][j] = graph[i][j];
					}
				}

				graph = result;

			} else if(K==6) { // 그룹나누고 왼쪽 방향으로
				int[][] result = new int[graph.length][graph[0].length];
				int r = graph.length; // 3,4 실행시 r,c가 달라지니까 무조건..
				int c = graph[0].length;
				
				// 1 -> 4
				for (int i = 0; i < r / 2; i++) {
					for (int j = 0; j < c / 2; j++) {
						result[(r/2)+i][j] = graph[i][j];
					}
				}
				// 4 -> 3
				for (int i = r/2; i<r; i++) {
					for (int j = 0; j<c/2; j++) {
						result[i][(c/2)+j] = graph[i][j];
					}
				}
				// 3 -> 2
				for (int i = r/2; i<r; i++) {
					for (int j = c/2; j<c; j++) {
						result[i-(r/2)][j] = graph[i][j];
					}
				}
				// 2 -> 1
				for (int i =0; i < r/2; i++) {
					for (int j = c/2; j < c; j++) {
						result[i][j-(c/2)] = graph[i][j];
					}
				}

				graph = result;
			}
		}
		print();

	}

	static void print() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}

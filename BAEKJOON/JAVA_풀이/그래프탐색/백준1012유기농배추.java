import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1012유기농배추 {
   static int m, n, k;
   static int[][] graph;
   static boolean[][] visited;
   static int result;
   static int[] dy = {-1, 1, 0, 0};
   static int[] dx = {0, 0, -1, 1};
   
   
   static void bfs(int y, int x) {
      // TODO Auto-generated method stub
      Queue<int[]> q = new LinkedList<int[]>();
      q.add(new int[] {y, x});
      
      while(!q.isEmpty()) {
         y = q.peek()[0];
         x = q.peek()[1];
         visited[y][x] = true;
         q.poll();
         for (int l = 0; l < 4; l++) {
            int yy = y + dy[l];
            int xx = x + dx[l];
            if (yy >= 0 && xx >= 0 && yy < n && xx < m) {
               if (!visited[yy][xx] && graph[yy][xx] == 1) {
                  q.add(new int[] {yy, xx});
                  visited[yy][xx] = true;
               }
            }
         }
      }
   }
   
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      for (int i = 0; i < t; i++) {
         result = 0;
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         m = Integer.parseInt(st.nextToken()); // 가로
         n = Integer.parseInt(st.nextToken()); // 세로
         k = Integer.parseInt(st.nextToken());
         
         graph = new int[n][m]; 
         visited = new boolean[n][m];
         
         for (int j = 0; j < k; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b][a] = 1;
         }
         
         
         for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
               if (graph[y][x] == 1 && !visited[y][x]) {
                  bfs(y, x);
                  result++;
               }
            }
         }
         System.out.println(result);
      }
   }
}
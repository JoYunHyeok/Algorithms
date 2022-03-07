import java.util.*;

class Solution {
    static List<List<Integer>> list; 
    public int solution(int n, int[][] wires) {
        int answer = -1;
        list = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<wires.length; i++){
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        

        int min = Integer.MAX_VALUE; // 최댓값 설정
        for(int i=1; i<=n; i++){
            for(int num : list.get(i)){
                if(i < num) min = Math.min(min, Math.abs(bfs(i, num, n) - bfs(num, i, n)));
            }
        }
        
        return min;
    }
    
    static int bfs(int start, int end, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int cnt = 1;
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int v = q.poll();
            
            for(int i : list.get(v)){
                if(!visited[i] && i != end){
                    q.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
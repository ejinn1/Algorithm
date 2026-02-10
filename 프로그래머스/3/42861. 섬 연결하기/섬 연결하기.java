import java.util.*;

class Solution {
    static class Edge{
        int v, w;
        
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<Edge>[] graph = new List[n];
        for(int i=0 ; i<n ; i++) graph[i] = new ArrayList<>();
        
        for(int i=0 ; i<costs.length ; i++){
            int u = costs[i][0];
            int v = costs[i][1];
            int w = costs[i][2];
            
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        
        int result = 0;
        int cnt = 0;
        
        visited[0] = true;
        cnt++;
        
        for(Edge e: graph[0]) pq.offer(e);
        
        while(!pq.isEmpty() && cnt < n){
            Edge cur = pq.poll();
            
            if(visited[cur.v]) continue;
            
            visited[cur.v] = true;
            result += cur.w;
            cnt++;
            
            for(Edge next: graph[cur.v]){
                if(!visited[next.v]) pq.offer(next);
            }
        }
        
        return result;
    }
}
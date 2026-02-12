import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {

        int answer = 0;
        
        int[] indegree = new int[n+1];
        
        List<Integer>[] graph = new List[n+1];
        Set<Integer>[] wins = new HashSet[n+1];
        Set<Integer>[] loses = new HashSet[n+1];
        
        for(int i=1 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
            wins[i] = new HashSet<>();
            loses[i] = new HashSet<>();
        }
        
        for(int[] result : results){
            int A = result[0];
            int B = result[1];
            
            indegree[B]++;
            graph[A].add(B);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1 ; i<=n ; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph[cur]){
                indegree[next]--;
                
                for(int winner : wins[cur]){
                    wins[next].add(winner);
                }
                
                wins[next].add(cur);
                
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
        
        
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                if(i == j) continue;
                
                if(wins[j].contains(i)){
                    loses[i].add(j);
                }
            }
        }
        
        for(int i=1 ; i<=n ; i++){
            if(wins[i].size() + loses[i].size() == n-1) answer++;
        }
        
        return answer;
    }
}

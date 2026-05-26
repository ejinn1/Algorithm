import java.util.*;

class Solution {
    static int[][][] cost;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int n;
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        n = board[0].length;
        
        cost = new int[n][n][4];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, -1, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int prevDir = cur[2];
            int curCost = cur[3];
            
            for(int d=0 ; d<4 ; d++){
                int cx = x + dx[d];
                int cy = y + dy[d];
            
                if(cx < 0 || cx >= n || cy < 0 || cy >= n) continue;
                if(board[cx][cy] == 1) continue;
                
                int nextCost;

                if (prevDir == -1) {
                    nextCost = 100;
                } else if (prevDir == d) {
                    nextCost = curCost + 100;
                } else {
                    nextCost = curCost + 600;
                }
                
                if (cost[cx][cy][d] > nextCost) {
                    cost[cx][cy][d] = nextCost;
                    q.offer(new int[]{cx, cy, d, nextCost});
                }
            }
        }
        
        for(int d=0 ; d<4 ; d++){
            answer = Math.min(answer, cost[n-1][n-1][d]);
        }
        
        return answer;
    }
}
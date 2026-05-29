import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            int k = type == 1 ? -1  : 1;
            int value = k * degree;
            
            dp[r1][c1] += value;
            dp[r1][c2 + 1] -= value;
            dp[r2 + 1][c1] -= value;
            dp[r2 + 1][c2 + 1] += value;
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }

        for (int j = 0; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                dp[i][j] += dp[i - 1][j];
            }
        }
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                board[i][j] += dp[i][j];
            }
        }
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i][j] > 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
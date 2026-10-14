import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        dp[1][1] = matrix[1][1];

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                if (i == 1 && j == 1) continue;

                dp[i][j] = Math.min(
                    Math.max(dp[i - 1][j], matrix[i][j]),
                    Math.max(dp[i][j - 1], matrix[i][j])
                );
            }
        }

        System.out.print(dp[n][n]);

    }
}
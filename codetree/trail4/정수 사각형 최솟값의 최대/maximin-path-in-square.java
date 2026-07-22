import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N+1][N+1];
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N+1][N+1];
        dp[0][1] = Integer.MAX_VALUE;
        
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                dp[i][j] = Math.max(Math.min(dp[i-1][j], arr[i][j]), Math.min(dp[i][j-1], arr[i][j]));
            }
        }

        System.out.print(dp[N][N]);
    }
}
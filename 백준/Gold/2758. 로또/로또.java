import java.util.*;

public class Main {
    static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String[] inputs = sc.nextLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            long[][] dp = new long[n + 1][m + 1];

            for(int i=0 ; i<m+1 ; i++){
                dp[0][i] = 1;
            }

            for(int i=1 ; i<n+1 ; i++){
                for(int j=1 ; j<m+1 ; j++){
                    dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
                }
            }

            System.out.println(dp[n][m]);
        }
    }
}

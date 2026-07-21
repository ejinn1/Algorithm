import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N + 1][N + 2];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[1][N] = arr[1][N];

        for (int i = 1; i <= N; i++) {
            for (int j = N; j >= 1; j--) {
                if (i == 1 && j == N) {
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + arr[i][j];
            }
        }

        System.out.print(dp[N][1]);
    }
}
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[][] matrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }

    int[][] dp = new int[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int height = 1; height <= N; height++) {
          for (int width = 1; width <= M; width++) {
            if(i + height > N || j + width > M) continue;
            int sum = dp[i + height][j + width] - dp[i + height][j] - dp[i][j + width] + dp[i][j];
            max = Math.max(max, sum);
          }
        }
      }
    }

    System.out.println(max);

  }
}
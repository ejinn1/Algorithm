import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] t = new int[N];
    int[] p = new int[N];

    for (int i = 0; i < N; i++) {
      t[i] = sc.nextInt();
      p[i] = sc.nextInt();
    }

    int[] dp = new int[N + 1];
    for (int i = 0; i < N; i++) {
      // 현재 선택 안함
      dp[i + 1] = Math.max(dp[i + 1], dp[i]);

      // 현재 선택 함
      if (i + t[i] <= N) {
        dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
      }
    }

    int max = 0;
    for (int i = 0; i <= N; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }

}
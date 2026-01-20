import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    boolean[] dp = new boolean[N + 1];

    int[] moves = {1, 3, 4};
    for (int i = 1; i <= N; i++) {
      boolean win = false;

      for (int m : moves) {
        if (i - m <= 0) continue;

        if (!dp[i - m]) {
          win = true;
          break;
        }
      }

      dp[i] = win;
    }

    System.out.println(dp[N] ? "SK" : "CY");
  }
}
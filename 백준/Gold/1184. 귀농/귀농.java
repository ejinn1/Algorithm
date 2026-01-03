import java.util.HashMap;
import java.util.Scanner;

public class Main {
  static long[][] dp;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] arr = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    dp = new long[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
      }
    }

    int result = 0;
    for (int i = 1; i <= N - 1; i++) {
      for (int j = 1; j <= N - 1; j++) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int r = 1; r <= i; r++) {
          for (int c = 1; c <= j; c++) {
            long s = sum(r, c, i, j);
            map.put(s, map.getOrDefault(s, 0) + 1);
          }
        }

        for (int r2 = i + 1; r2 <= N; r2++) {
          for (int c2 = j + 1; c2 <= N; c2++) {
            long s = sum(i + 1, j + 1, r2, c2);
            Integer cnt = map.get(s);
            if(cnt != null) result += cnt;
          }
        }

        map.clear();

        for (int r = 1; r <= i; r++) {
          for (int c2 = j + 1; c2 <= N; c2++) {
            long s = sum(r, j + 1, i, c2);
            map.put(s, map.getOrDefault(s, 0) + 1);
          }
        }

        for (int r2 = i + 1; r2 <= N; r2++) {
          for (int c = 1; c <= j; c++) {
            long s = sum(i + 1, c, r2, j);
            Integer cnt = map.get(s);
            if(cnt != null) result += cnt;
          }
        }
      }
    }

    System.out.println(result);
  }

  static long sum(int r1, int c1, int r2, int c2) {
    if(r1 > r2 || c1 > c2) return 0;
    return dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
  }
}
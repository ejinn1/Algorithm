import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }

    int[] dp = new int[N + 1];
    dp[0] = nums[0];
    int max = dp[0];

    for (int i = 1; i < N; i++) {
      dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
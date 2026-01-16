import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static int N, S;
  static int[] nums;
  static int result = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    S = sc.nextInt();

     nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }

    Arrays.sort(nums);

    dfs(0, 0);
    
    if(S == 0) result--;

    System.out.println(result);
  }

  static void dfs(int sum, int i) {
    if (i == N) {
      if(sum == S) result++;
      return;
    }

    dfs(sum + nums[i], i + 1);
    dfs(sum, i + 1);
  }
}
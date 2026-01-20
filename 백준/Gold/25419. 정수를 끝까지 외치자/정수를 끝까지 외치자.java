import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    sc.nextLine();

    boolean[] no = new boolean[n + 1];

    List<Integer> nums = Arrays.stream(sc.nextLine()
                    .split(" "))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

    for (int num : nums) {
      no[num] = true;
    }

    boolean[] dp = new boolean[n + 1];
    for (int a = n; a >= 0; a--) {
      for (int b = a + 1; b <= Math.min(n, a + k); b++) {
        if (!no[b] && !dp[b]) {
          dp[a] = true;
          break;
        }
      }
    }

    System.out.println(dp[0] ? 1 : 0);
  }
}
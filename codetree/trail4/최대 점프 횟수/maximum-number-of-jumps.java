
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[n];
        Arrays.fill(dp, -2);

        int res = dfs(0);

        System.out.print(res);
    }

    static int dfs(int cur) {
        if (cur == n - 1) return 0;

        if (dp[cur] != -2) return dp[cur];

        int cnt = 0;
        int jump = arr[cur];

        for (int j = cur + 1; j <= cur + jump; j++) {
            if (j >= n) break;

            int next = dfs(j);

            if (next != -1) {
                cnt = Math.max(cnt, next + 1);
            }
        }

        return dp[cur] = cnt;
    }
}

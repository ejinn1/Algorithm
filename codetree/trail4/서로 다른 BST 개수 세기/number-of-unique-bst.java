import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];
        dp[0] = 1;

        for(int n=1 ; n<=N ; n++){
            for(int root=1 ; root<=n ; root++){
                int left = root - 1;
                int right = n - root;

                dp[n] += dp[left] * dp[right];
            }
        }

        System.out.print(dp[N]);
    }
}
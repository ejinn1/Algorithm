import java.util.*;

public class Main {
    static int MOD = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N == 1) {
            System.out.print(1);
            return;
        }

        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2 ; i<=N ; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % MOD;
        }

        System.out.print(dp[N]);
        
    }
}
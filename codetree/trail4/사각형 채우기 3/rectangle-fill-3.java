import java.util.*;

public class Main {
    static Long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Long[] dp = new Long[N+1];
        dp[0] = 1L;

        if(N == 1){
            System.out.print(2);
            return;
        } else if(N == 2){
            System.out.print(7);
            return;
        }
        dp[1] = 2L;
        dp[2] = 7L;

        for(int i=3 ; i<=N ; i++){
            dp[i] = (dp[i-1] * 3 + dp[i-2] - dp[i-3] + MOD) % MOD; 
        }
        
        System.out.print(dp[N]);
    }
}
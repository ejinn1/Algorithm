import java.util.*;

public class Main {
    static int DIV = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N == 1) {
            System.out.print(1);
            return;
        }

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3 ; i<=N ; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % DIV;
        }

        System.out.print(dp[N]);
        
    }
}
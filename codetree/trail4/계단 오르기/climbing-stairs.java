import java.util.*;

public class Main {
    static int DIV = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N == 2) {
            System.out.print(1);
            return;
        }

        int[] dp = new int[N+1];
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4 ; i<=N ; i++){
            dp[i] = (dp[i-2] + dp[i-3]) % DIV;
        }

        System.out.print(dp[N] % DIV);


    }
}
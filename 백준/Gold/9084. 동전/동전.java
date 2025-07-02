import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for(int k=0 ; k<t ; k++){
            int n = Integer.parseInt(sc.nextLine());

            String[] parts = sc.nextLine().split(" ");
            int[] coins = new int[parts.length];
            for(int i=0 ; i<parts.length ; i++){
                coins[i] = Integer.parseInt(parts[i]);
            }

            int cash = Integer.parseInt(sc.nextLine());
            int[] dp = new int[cash + 1];
            dp[0] = 1;

            for(int coin : coins){
                for(int i=coin ; i<=cash ; i++){
                    dp[i] += dp[i - coin];
                }
            }

            System.out.println(dp[cash]);
        }

    }
}

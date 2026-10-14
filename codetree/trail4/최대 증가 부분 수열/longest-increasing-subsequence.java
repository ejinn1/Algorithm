import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int[] dp = new int[n];
        // for(int i=0 ; i<n ; i++) dp[i] = 1;
        Arrays.fill(dp, 1);
        
        for(int i=0 ; i<n-1 ; i++){
            for(int j=i+1 ; j<n ; j++){
                if(arr[j] > arr[i]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int max = 0;
        for(int i=0 ; i<n ; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }
}
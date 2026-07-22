import java.util.*;

public class Main {
    static int N;
    static int max, min;
    static int[][] arr, dp;
    static Set<Integer> candidates = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        max = 0;
        min = Integer.MAX_VALUE;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                arr[i][j] = sc.nextInt();
                candidates.add(arr[i][j]);
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int left = 0;
        int right = max - min;
        int ans = 0;
        boolean[][] dp = new boolean[N+1][N+1];
        while(left <= right){
            int mid = (int) (left + right) / 2;
            
            if(possible(mid)){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }
    
    static boolean possible(int diff){
        for(int row : candidates){
            int high = row + diff;

            if(canGo(row, high)){
                return true;
            }
        }

        return false;
    }

    static boolean canGo(int row, int high){
        boolean[][] dp = new boolean[N+1][N+1];

        if(arr[0][0] < row || arr[0][0] > high) return false;

        dp[0][0] = true;

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(arr[i][j] < row || arr[i][j] > high) continue;

                if(i > 0 && dp[i-1][j]){
                    dp[i][j] = true;
                }
                
                if(j > 0 && dp[i][j-1]){
                    dp[i][j] = true;
                }
            }
        }

        return dp[N-1][N-1];

    }
}
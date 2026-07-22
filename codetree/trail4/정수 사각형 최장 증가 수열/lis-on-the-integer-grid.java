import java.util.*;

public class Main {
    static int N;
    static int[][] arr, dp;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        dp = new int[N+1][N+1];
        int ans = 0;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                ans = Math.max(ans, dfs(i, j));
            }
        }

        System.out.print(ans);
    }

    static int dfs(int x, int y){
        if(dp[x][y] > 0){
            return dp[x][y];
        }

        dp[x][y] = 1;

        for(int d=0 ; d<4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if(arr[nx][ny] > arr[x][y]){
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }

        return dp[x][y];
    }
}
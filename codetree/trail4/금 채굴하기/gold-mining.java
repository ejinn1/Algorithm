import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int max = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                for(int k=0 ; k<=2*(n+1) ; k++){
                    max = Math.max(max, rhombus(i, j, k));
                }
            }
        }

        System.out.print(max);
    }

    static int rhombus(int x, int y, int k){
        int cnt = 0;

        for(int i=x-k ; i<=x+k ; i++){
            for(int j=y-k ; j<=y+k ; j++){
                if(Math.abs(i - x) + Math.abs(j - y) > k) continue;
                if(i < 0 || i >= n || j < 0 || j >= n) continue;
                if(grid[i][j] == 0) continue;

                cnt++;
            }
        }

        return cnt * m - (k * k + (k + 1) * (k + 1)) >= 0 ? cnt : 0;
    }
}
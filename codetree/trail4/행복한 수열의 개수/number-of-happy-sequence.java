import java.util.*;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        if (m == 1) {
            System.out.print(2 * n);
            return;
        }
        
        int cnt = 0;

        for(int i=0 ; i<n ; i++){
            int prev = grid[i][0];
            int tmp = 1;
            for(int j=1 ; j<n ; j++){
                if(prev == grid[i][j]) {
                    tmp++;
                    if(tmp >= m) {
                        cnt++;
                        break;
                    }
                }
                else tmp = 1;

                prev = grid[i][j];
            }
            
            // if(tmp >= m) cnt++;
        }

        for(int j=0 ; j<n ; j++){
            int prev = grid[0][j];
            int tmp = 1;
            for(int i=1 ; i<n ; i++){
                if(prev == grid[i][j]) {
                    tmp++;
                    if(tmp >= m) {
                        cnt++;
                        break;
                    }
                }
                else tmp = 1;

                prev = grid[i][j];
            }

            // if(tmp >= m) cnt++;
        }

        

        System.out.print(cnt);
    }
}
import java.util.*;

public class Main {
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int max = 0;
        for(int i=0 ; i<n-2 ; i++){
            for(int j=0 ; j<n-2 ; j++){
                max = Math.max(max, countOne(i, j));
            }
        }

        System.out.print(max);
    }

    static int countOne(int x, int y){
        int cnt = 0;

        for(int i=x ; i<x+3 ; i++){
            for(int j=y ; j<y+3 ; j++){
                if(grid[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }
}
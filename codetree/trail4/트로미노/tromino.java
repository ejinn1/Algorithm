import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int n, m;

    static int[][][] shapes = {
        {{0, 0}, {0, 1}, {0, 2}},
        {{0, 0}, {1, 0}, {2, 0}},
        {{0, 0}, {1, 0}, {1, 1}},
        {{0, 0}, {0, 1}, {1, 0}},
        {{0, 0}, {0, 1}, {1, 1}},
        {{0, 1}, {1, 0}, {1, 1}}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                for(int t=0 ; t<6 ; t++){
                    max = Math.max(max, block(i, j, t));
                }
            }
        }

        System.out.print(max);
    }

    static int block(int x, int y, int t){
        int cnt = 0;
        for(int[] cur : shapes[t]){
            int nx = x + cur[0];
            int ny = y + cur[1];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) return 0;
            cnt += grid[nx][ny];
        }

        return cnt;
    }
}
import java.util.*;

public class Main {
    static int n, k;
    static int[][] grid, starts;
    static boolean[][] check;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        starts = new int[k][2];

        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt();
            starts[i][1] = sc.nextInt();
        }

        visited = new boolean[n][n];
        for(int[] start : starts){
            int x = start[0] - 1;
            int y = start[1] - 1;

            check[x][y] = true;

            bfs(x, y);
        }

        int ans = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(check[i][j]) ans++;
            }
        }

        System.out.print(ans);
    }
    
    static void bfs(int x, int y){
        for(int d=0 ; d<4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(grid[nx][ny] == 1) continue;
            if(visited[nx][ny]) continue;

            check[nx][ny] = true;
            visited[nx][ny] = true;
            bfs(nx, ny);
        }
    }
}
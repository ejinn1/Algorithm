import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean possible = false;
    static boolean[][] visited;
    static int[] dx = new int[]{1, 0};
    static int[] dy = new int[]{0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        visited = new boolean[n+1][m+1];
        visited[0][0] = true;
        dfs(0, 0);

        System.out.print(possible ? "1": "0");

    }

    static void dfs(int x, int y){
        if(x == n-1 && y == m-1) {
            possible = true;
            return;
        }

        for(int d=0 ; d<2 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(grid[nx][ny] == 0) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}
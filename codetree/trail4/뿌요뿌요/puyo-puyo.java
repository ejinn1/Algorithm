import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int max = Integer.MIN_VALUE;
    static int maxN = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][n];
        int count = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(visited[i][j]) continue;
                visited[i][j] = true;
                int c = dfs(i, j, grid[i][j]);
                max = Math.max(max, c);
                if(c >= 4) count++;
            }
        }

        System.out.print(count + " " + max);
        
    }

    static int dfs(int x, int y, int num){
        int cnt = 1;

        for(int d=0 ; d<4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(visited[nx][ny]) continue;
            if(grid[nx][ny] != num) continue;

            visited[nx][ny] = true;
            cnt += dfs(nx, ny, num);
        }

        return cnt;
    }
}
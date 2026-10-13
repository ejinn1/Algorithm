import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
                max = Math.max(max, grid[i][j]);
            }
        }
                

        int K = 1;
        int cnt = 0;
        for(int k=1 ; k<=max ; k++){
            int c = countSafeAreas(k);
            if(c > cnt){
                K = k;
                cnt = c;
            }
        }

        System.out.print(K + " " + cnt);
        
    }

    static int countSafeAreas(int k){
        visited = new boolean[n][m];
        int num = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(visited[i][j]) continue;
                if(grid[i][j] - k <= 0) continue;
                num++;
                visited[i][j] = true;
                dfs(i, j, k);
            }
        }

        return num;
    }

    static void dfs(int x, int y, int k){
        
        for(int d=0 ; d<4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(visited[nx][ny]) continue;
            if(grid[nx][ny] - k <= 0) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, k);
        }
    }



    
}
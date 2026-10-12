import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][n];
        int num = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(visited[i][j]) continue;
                if(grid[i][j] == 0) continue;

                visited[i][j] = true;
                num++;
                dfs(i, j, num);
            }
        }
        
        List<Integer> cnts = new ArrayList<>();
        for(int c=1 ; c<=num ; c++){
            cnts.add(getCnt(c));
        }
        
        Collections.sort(cnts);

        System.out.println(num);
        for(int c : cnts){
            System.out.println(c);
        }
    }

    static void dfs(int x, int y, int num){
        grid[x][y] = num;
        
        for(int d=0 ; d<4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(visited[nx][ny]) continue;
            if(grid[nx][ny] == 0) continue;
            
            visited[nx][ny] = true;
            dfs(nx, ny, num);
        }
    }

    static int getCnt(int c){
        int cnt = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == c) cnt++;
            }
        }

        return cnt;
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for(int step=0 ; step<k ; step++){
            boolean[][] visited = new boolean[n][n];

            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{r, c});

            int s = grid[r][c];

            while(!q.isEmpty()){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                
                for(int d=0 ; d<4 ; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(visited[nx][ny]) continue;
                    if(s <= grid[nx][ny]) continue;

                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

            int max = -1;
            int nextR = -1;
            int nextC = -1;

            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){
                    if(visited[i][j] && grid[i][j] > max){
                        nextR = i;
                        nextC = j;
                        max = grid[i][j];
                    }
                }
            }

            if(nextR == -1){
                break;
            }

            r = nextR;
            c = nextC;
        }

        System.out.print((r+1) + " " + (c+1));
    }
}
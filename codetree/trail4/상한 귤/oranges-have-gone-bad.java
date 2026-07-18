import java.util.*;

public class Main {
    static class Node{
        int x, y, k;

        Node(int x, int y, int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] grid = new int[N][N];
        int[][] ans = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                ans[i][j] = -1;
            }
        }

        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2){
                    q.offer(new Node(i, j, 0));
                    ans[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        while(!q.isEmpty()){
            Node cur = q.poll();
            ans[cur.x][cur.y] = cur.k;
            grid[cur.x][cur.y] = 3;
            
            for(int d=0 ; d<4 ; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(grid[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, cur.k + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(grid[i][j] == 1){
                    sb.append(-2).append(" ");
                } else {
                    sb.append(ans[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
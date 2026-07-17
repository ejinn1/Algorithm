import java.util.*;

public class Main {
    static class Pair{
        int x, y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        
        int[][] arr = new int[n+1][n+1];
        int[][] step = new int[n+1][n+1];
        boolean[][] visited = new boolean[n+1][n+1];
        int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(r1, c1));
        visited[r1][r2] = true;

        while(!q.isEmpty()){
            Pair cur = q.poll();

            if(cur.x == r2 && cur.y == c2){
                break;
            }

            for(int d=0 ; d<8 ; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                step[nx][ny] = step[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
        
        int ans = -1;

        if(r1 == r2 && c1 == c2){
            ans = 0;
        } else if(step[r2][c2] != 0){
            ans = step[r2][c2];
        }

        System.out.print(ans);

    }
}
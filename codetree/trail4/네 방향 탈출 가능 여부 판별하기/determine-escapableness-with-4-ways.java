import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;
        bfs(0, 0);

        System.out.print(ans);
    }

    static void bfs(int x, int y){
        if(x == N-1 && y == M-1){
            ans = 1;
            return;
        }

        for(int d=0 ; d<4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny]) continue;
            if(arr[nx][ny] == 0) continue;

            visited[nx][ny] = true;
            bfs(nx, ny);
        }
    }
}
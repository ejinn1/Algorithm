import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[N][M];

        int[][] arr = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int ans = -1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if(x == N-1 && y == M-1){
                ans = dist;
                break;
            }

            for(int d=0 ; d<4 ; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        System.out.print(ans);
    }
}

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M, T;
    static int[][] castle;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        castle = new int[N][M];
        int swordX = 0, swordY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                castle[i][j] = sc.nextInt();
                if(castle[i][j] == 2){
                    swordX = i;
                    swordY = j;
                }
            }
        }

        int normal = dfs(0, 0, N - 1, M - 1);

        int withSword = dfs(0, 0, swordX, swordY);

        int viaSword = -1;
        if (withSword != -1) {
            viaSword = withSword + (N - 1 - swordX) + (M - 1 - swordY);
        }

        int ans = Integer.MAX_VALUE;
        if(normal != -1) ans = normal;
        if(viaSword != -1) ans = Math.min(ans, viaSword);

        if (ans <= T) {
            System.out.println(ans);
        } else {
            System.out.println("Fail");
        }
    }

    static int dfs(int x, int y, int targetX, int targetY) {
        dist = new int[N][M];
        for(int[] row: dist) Arrays.fill(row, -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if(cx == targetX && cy == targetY){
                return dist[cx][cy];
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(dist[nx][ny] != -1) continue;
                if(castle[nx][ny] == 1) continue;

                dist[nx][ny] = dist[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        return -1;
    }
}

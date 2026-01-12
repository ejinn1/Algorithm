import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int K = sc.nextInt();

      int[][] arr = new int[N][M];

      for (int k = 0; k < K; k++) {
        int x = sc.nextInt();
        int y = sc.nextInt();

        arr[x][y] = 1;
      }

      boolean[][] visited = new boolean[N][M];
      int[] dx = new int[]{0, 0, -1, 1};
      int[] dy = new int[]{-1, 1, 0, 0};
      int cnt = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (!visited[i][j] && arr[i][j] == 1) {
            cnt++;
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{i, j});
            visited[i][j] = true;

            while (!q.isEmpty()) {
              int[] cur = q.poll();
              int x = cur[0];
              int y = cur[1];

              for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] != 1) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
              }
            }
          }
        }
      }

      System.out.println(cnt);

    }
  }
}
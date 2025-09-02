

import java.util.*;

public class Main {
  static int N, M;
  static int[][] arr;
  static int[][] dist;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = sc.next();
      for (int j = 0; j < M; j++) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(bfs(0, 0));
  }

  static int bfs(int x, int y){
    dist = new int[N][M];
    boolean[][] visited = new boolean[N][M];
    ArrayDeque<int[]> q = new ArrayDeque<>();

    visited[x][y] = true;
    dist[x][y] = 1;
    q.add(new int[]{x, y});

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];

      if (cx == N - 1 && cy == M - 1) {
        return dist[cx][cy];
      }

      for (int d = 0; d < 4; d++) {
        int nx = cx + dx[d];
        int ny = cy + dy[d];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(arr[nx][ny] == 0) continue;
        if(visited[nx][ny]) continue;

        visited[nx][ny] = true;
        dist[nx][ny] = dist[cx][cy] + 1;
        q.add(new int[]{nx, ny});
      }
    }

    return -1;
  }
}

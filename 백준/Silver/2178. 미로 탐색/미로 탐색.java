

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[][] arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      String line = sc.next();
      for (int j = 0; j < M; j++) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }


    ArrayDeque<int[]> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][M];
    int[][] dist = new int[N][M];
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int result = -1;

    q.add(new int[]{0, 0});
    visited[0][0] = true;
    dist[0][0] = 1;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      if (x == N - 1 && y == M - 1) {
        result = dist[x][y];
        break;
      }

      for (int d = 0; d < 4; d++) {
        int cx = x + dx[d];
        int cy = y + dy[d];

        if(cx < 0 || cx >= N || cy < 0 || cy >= M) continue;
        if(arr[cx][cy] == 0) continue;
        if(visited[cx][cy]) continue;

        visited[cx][cy] = true;
        dist[cx][cy] = dist[x][y] + 1;
        q.add(new int[]{cx, cy});
      }
    }


    System.out.println(result);
  }
}

import java.util.*;

public class Main {
  static int N, M;
  static int[][] room;
  static boolean[][] visited;
  static int[] dx = new int[]{-1, 0, 1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    room = new int[N][M];

    int x = sc.nextInt();
    int y = sc.nextInt();
    int d = sc.nextInt();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        room[i][j] = sc.nextInt();
      }
    }

    visited = new boolean[N][M];
    int cnt = 0;

    while(true){
      if(!visited[x][y]){
        visited[x][y] = true;
        cnt++;
      }

      boolean moved = false;
      for (int i = 0; i < 4; i++) {
        // 3 -> 2 -> 1 -> 0
        d = (d + 3) % 4;
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(room[nx][ny] == 0 && !visited[nx][ny]){
          x = nx;
          y = ny;
          moved = true;
          break;
        }
      }

      if(moved) continue;

      int backD = (d + 2) % 4;
      int cx = x + dx[backD];
      int cy = y + dy[backD];

      if(cx < 0 || cx >= N || cy < 0 || cy >= M || room[cx][cy] == 1) break;
      x = cx;
      y = cy;
    }

    System.out.println(cnt);

  }
}
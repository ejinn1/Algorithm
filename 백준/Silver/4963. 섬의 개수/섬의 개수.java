import java.util.Scanner;

public class Main {
  static int w, h;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
  static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    while (true) {
      w = sc.nextInt();
      h = sc.nextInt();
      if(w == 0 && h == 0) break;

      arr = new int[h][w];
      visited = new boolean[h][w];

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          arr[i][j] = sc.nextInt();
        }
      }

      int cnt = 0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (arr[i][j] == 1 && !visited[i][j]) {
            dfs(i, j);
            cnt++;
          }
        }
      }

      System.out.println(cnt);
    }
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int d = 0; d < 8; d++) {
      int nx = x + dx[d];
      int ny = y + dy[d];

      if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
      if(visited[nx][ny]) continue;
      if(arr[nx][ny] == 0) continue;

      dfs(nx, ny);
    }
  }
}
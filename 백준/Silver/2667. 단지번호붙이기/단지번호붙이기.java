import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = new int[]{1, -1, 0, 0};
  static int[] dy = new int[]{0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    List<Integer> sizes = new ArrayList<>();
    visited = new boolean[N][N];
    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          sizes.add(dfs(i, j));
          result++;
        }
      }
    }

    System.out.println(result);
    Collections.sort(sizes);
    for(int s: sizes) System.out.println(s);
  }

  static int dfs(int x, int y) {
    visited[x][y] = true;
    int cnt = 1;

    for (int d = 0; d < 4; d++) {
      int cx = x + dx[d];
      int cy = y + dy[d];

      if(cx < 0 || cx >= N || cy < 0 || cy >= N) continue;
      if (visited[cx][cy]) continue;
      if (map[cx][cy] != 1) continue;
      cnt += dfs(cx, cy);
    }

    return cnt;
  }
}
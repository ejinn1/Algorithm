

import java.util.*;

public class Main {
  static int N;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    arr = new int[N][N];

    for (int i = 0; i < N; i++) {
      String line = sc.next();
      for (int j = 0; j < N; j++) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }

    visited = new boolean[N][N];
    List<Integer> sizes = new ArrayList<>();
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          sizes.add(dfs(i, j));
        }
      }
    }

    Collections.sort(sizes);
    System.out.println(sizes.size());
    for(int s: sizes) System.out.println(s);
  }

  static int dfs(int x, int y) {
    visited[x][y] = true;
    int cnt = 1;
    
    for (int d = 0; d < 4; d++) {
      int cx = x + dx[d];
      int cy = y + dy[d];

      if(cx < 0 || cx >= N || cy < 0 || cy >= N) continue;
      if(arr[cx][cy] == 0) continue;
      if(visited[cx][cy]) continue;

      cnt += dfs(cx, cy);
    }

    return cnt;
  }
}



import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static int N;
  static int[][] arr;
  static boolean[][] visited;
  static int num = 0;
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

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          num++;
          dfs(i, j);
        }
      }
    }

    System.out.println(num);

    int[] result = new int[num+1];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] != 0) {
          result[arr[i][j]]++;
        }
      }
    }

    Arrays.sort(result);

    for (int i = 1; i <= num; i++) {
      System.out.println(result[i]);
    }


  }

  static void dfs(int x, int y) {
    visited[x][y] = true;
    arr[x][y] = num;

    for (int d = 0; d < 4; d++) {
      int cx = x + dx[d];
      int cy = y + dy[d];

      if(cx < 0 || cx >= N || cy < 0 || cy >= N) continue;
      if(arr[cx][cy] == 0) continue;
      if(visited[cx][cy]) continue;

      dfs(cx, cy);
    }
  }


}

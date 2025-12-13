import java.util.*;

public class Main {
  static int[] dx = {0, 0, 0, -1, 1};
  static int[] dy = {0, 1, -1, 0, 0};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    int K = sc.nextInt();

    int[][] board = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        board[i][j] = sc.nextInt();
      }
    }

    int[] d = new int[6];

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < K; i++) {
      int order = sc.nextInt();

      int nx = x + dx[order];
      int ny = y + dy[order];

      if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

      roll(d, order);

      x = nx;
      y = ny;

      if (board[x][y] == 0) {
        board[x][y] = d[1];
      } else {
        d[1] = board[x][y];
        board[x][y] = 0;
      }

      sb.append(d[0])
              .append("\n");
    }

    System.out.println(sb);
  }

  static void roll(int[] d, int order) {
    int top = d[0];
    int bottom = d[1];
    int north = d[2];
    int south = d[3];
    int west = d[4];
    int east = d[5];

    if (order == 1) {
      d[0] = west;
      d[1] = east;
      d[4] = bottom;
      d[5] = top;
    } else if (order == 2) {
      d[0] = east;
      d[1] = west;
      d[4] = top;
      d[5] = bottom;
    } else if (order == 3) {
      d[0] = south;
      d[1] = north;
      d[2] = top;
      d[3] = bottom;
    } else if (order == 4) {
      d[0] = north;
      d[1] = south;
      d[2] = bottom;
      d[3] = top;
    }
  }
}
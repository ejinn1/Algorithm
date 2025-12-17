import java.util.Scanner;

public class Main {
  static int N;
  static int[][] board;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    board = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = sc.nextInt();
      }
    }

    visited = new boolean[N];
    dfs(0, 0);

    System.out.println(min);
  }

  static void dfs(int idx, int cnt) {
    if (cnt == N / 2) {
      diff();
      return;
    }

    for (int i = idx; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(i + 1, cnt + 1);
        visited[i] = false;
      }
    }
  }

  static void diff() {
    int A = 0;
    int B = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (visited[i] && visited[j]) {
          A += board[i][j];
          A += board[j][i];
        } else if (!visited[i] && !visited[j]) {
          B += board[i][j];
          B += board[j][i];
        }
      }
    }

    min = Math.min(min, Math.abs(A - B));
  }
}
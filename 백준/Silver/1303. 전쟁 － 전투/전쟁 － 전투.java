import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static char[][] arr;
  static boolean[][] visited;
  static int N, M;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    sc.nextLine();

    arr = new char[M][N];

    for (int i = 0; i < M; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = line.charAt(j);
      }
    }

    visited = new boolean[M][N];

    int W = 0;
    int B = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if(visited[i][j]) continue;
        char c = arr[i][j];
        int cnt = bfs(i, j, c);
        int power = (int) Math.pow(cnt, 2);
        if(c == 'W') W += power;
        else B += power;
      }
    }

    System.out.println(W + " " + B);
  }

  static int bfs(int i, int j, char c) {
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{i, j});
    int cnt = 1;
    visited[i][j] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx < 0  || nx >= M || ny < 0 || ny >= N) continue;
        if(visited[nx][ny]) continue;
        if(arr[nx][ny] != c) continue;

        visited[nx][ny] = true;
        cnt++;
        q.add(new int[]{nx, ny});
      }
    }

    return cnt;
  }
}
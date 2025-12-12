import java.util.*;

public class Main {
  static int N, M;
  static char[][] field;
  static boolean[][] visited;
  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{1, -1, 0, 0};
  static boolean isBoom = true;

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    N = 12;
    M = 6;
    field = new char[N][M];

    for (int i = 0; i < N; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < M; j++) {
        field[i][j] = line.charAt(j);
      }
    }

    int result = 0;
    while (isBoom) {
//      StringBuilder sb = new StringBuilder();
//      for (int i = 0; i < N; i++) {
//        for (int j = 0; j < M; j++) {
//          sb.append(field[i][j]).append(" ");
//        }
//        sb.append("\n");
//      }

//      System.out.println(sb);
      isBoom = false;
      visited = new boolean[N][M];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (field[i][j] != '.') {
            int cnt = bfs(i, j, field[i][j]);

            if (cnt >= 4) {
              isBoom = true;
            }
          }
        }
      }

      if(isBoom) result++;

      // 아래로 내리는거
      for (int j = 0; j < M; j++) {
        int k = N - 1;
        ArrayList<Character> puyos = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
          if(field[i][j] != '.'){
            puyos.add(field[i][j]);
            field[i][j] = '.';
          }
        }
        for (char puyo : puyos) {
          field[k][j] = puyo;
          k--;
        }
      }
    }

    System.out.println(result);
  }

  static int bfs(int i, int j, char puyo) {
    int cnt = 1;
    Queue<int[]> q = new ArrayDeque<>();
    Stack<int[]> stack = new Stack<>();
    q.add(new int[]{i, j});
    stack.add(new int[]{i, j});
    visited = new boolean[N][M];
    visited[i][j] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      for (int d = 0; d < 4; d++) {
        int cx = x + dx[d];
        int cy = y + dy[d];

        if(cx < 0 || cx >= N || cy < 0 || cy >= M) continue;
        if(visited[cx][cy]) continue;
        if(field[cx][cy] != puyo) continue;

        cnt++;
        q.add(new int[]{cx, cy});
        stack.add(new int[]{cx, cy});
        visited[cx][cy] = true;
      }
    }

    if (cnt >= 4) {
      for (int[] cur : stack) {
        int x = cur[0];
        int y = cur[1];

        field[x][y] = '.';
      }
    }

    return cnt;
  }
}


import java.util.*;

public class Main {
  static int N, M;
  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{1, -1, 0, 0};
  static int[][] cheezes;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    cheezes = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        cheezes[i][j] = sc.nextInt();
      }
    }

    int t = 0;
    int meltCnt = 0;
    while(true){
      int cnt = bfs();
      if(cnt == 0) break;
      meltCnt = cnt;
      t++;
    }

    System.out.println(t);
    System.out.println(meltCnt);
  }

  static int bfs(){
    boolean[][] visited = new boolean[N][M];
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0});
    visited[0][0] = true;

    Set<int[]> melts = new HashSet<>();

    while (!queue.isEmpty()){
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(visited[nx][ny]) continue;

        if (cheezes[nx][ny] == 0) {
          visited[nx][ny] = true;
          queue.add(new int[]{nx, ny});
        } else if (cheezes[nx][ny] == 1) {
          visited[nx][ny] = true;
          melts.add(new int[]{nx, ny});
        }
      }
    }

    melts.forEach(melt -> {
      int x = melt[0];
      int y = melt[1];
      cheezes[x][y] = 0;
    });

    return melts.size();
  }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    int[][] board = new int[N][N];

    StringTokenizer st;
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      board[x - 1][y - 1] = 1;
    }

    Map<Integer, String> turns = new TreeMap<>();
    int L = Integer.parseInt(br.readLine());
    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      String dir = st.nextToken();

      turns.put(x, dir);
    }

    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int dir = 0;

    Deque<int[]> snake = new ArrayDeque<>();
    snake.add(new int[]{0, 0});
    board[0][0] = 2;

    int time = 0;
    while (true) {
      time++;

      int[] head = snake.getFirst();
      int nr = head[0] + dr[dir];
      int nc = head[1] + dc[dir];

      if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
      if(board[nr][nc] == 2) break;

      if (board[nr][nc] == 1) {
        board[nr][nc] = 2;
        snake.addFirst(new int[]{nr, nc});
      } else {
        board[nr][nc] = 2;
        snake.addFirst(new int[]{nr, nc});
        int[] tail = snake.removeLast();
        board[tail[0]][tail[1]] = 0;
      }

      if (turns.get(time) != null) {
        String turnType = turns.get(time);
        if (turnType.equals("D")) {
          dir = (dir + 1) % 4;
        } else if(turnType.equals("L")) {
          dir = (dir + 3) % 4;
        }
      }
    }

    System.out.println(time);
  }
}
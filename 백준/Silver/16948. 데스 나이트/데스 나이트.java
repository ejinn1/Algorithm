import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  static class Node {
    int r;
    int c;
    int cnt;

    public Node(int r, int c, int cnt) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int r1 = sc.nextInt();
    int c1 = sc.nextInt();
    int r2 = sc.nextInt();
    int c2 = sc.nextInt();
    int[] dr = new int[]{-2, -2, 0, 0, 2, 2};
    int[] dc = new int[]{-1, 1, -2, 2, -1, 1};

    PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
    q.add(new Node(r1, c1, 0));
    int result = -1;
    boolean[][] visited = new boolean[N][N];
    visited[r1][c1] = true;

    while (!q.isEmpty()) {
      Node node = q.poll();

      int r = node.r;
      int c = node.c;
      int cnt = node.cnt;

      if (r == r2 && c == c2) {
        result = node.cnt;
        break;
      }

      for (int d = 0; d < 6; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
        if(visited[nr][nc]) continue;
        q.offer(new Node(nr, nc, cnt + 1));
        visited[nr][nc] = true;
      }
    }

    System.out.println(result);

  }
}
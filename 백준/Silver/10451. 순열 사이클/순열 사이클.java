

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    int N;
    while (T-- > 0) {
      N = sc.nextInt();

      List<Integer>[] graph = new ArrayList[N + 1];
      for (int i = 0; i <= N; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 1; i <= N; i++) {
        int k = sc.nextInt();
        graph[i].add(k);
      }

      boolean[] visited = new boolean[N + 1];
      int cnt = 0;

      for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
          bfs(i, graph, visited);
          cnt++;
        }
      }

      System.out.println(cnt);
    }
  }

  static void bfs(int start, List<Integer>[] graph, boolean[] visited) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(start);
    visited[start] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int next : graph[cur]) {
        if (!visited[next]) {
          visited[next] = true;
          q.add(next);
        }
      }
    }
  }
}

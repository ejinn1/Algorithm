

import java.util.*;

public class Main {
  static boolean[] visited;
  static List<Integer>[] graph;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int V = sc.nextInt();

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    visited = new boolean[N + 1];
    Arrays.fill(visited, false);
    dfs(V);
    System.out.println();

    Arrays.fill(visited, false);
    bfs(V);
    System.out.println();
  }

  static void dfs(int start){
    visited[start] = true;
    System.out.print(start + " ");
    for (int next : graph[start]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  static void bfs(int start){
    Queue<Integer> q = new LinkedList<>();
    visited[start] = true;
    q.add(start);
    while (!q.isEmpty()) {
      int cur = q.poll();
      System.out.print(cur + " ");
      for (int next : graph[cur]) {
        if (!visited[next]) {
          visited[next] = true;
          q.add(next);
        }
      }
    }
  }
}



import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      graph[u].add(v);
      graph[v].add(u);
    }

    visited = new boolean[N + 1];
    int result = 0;

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
        result++;
      }
    }

    System.out.println(result);
  }

  static void dfs(int node) {
    if(visited[node]) return;

    visited[node] = true;
    for (int next : graph[node]) {
      dfs(next);
    }
  }
}

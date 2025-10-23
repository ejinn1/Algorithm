

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
  static boolean[] visited;
  static ArrayList<Integer>[] graph;
  static int cnt;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < K; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      graph[u].add(v);
      graph[v].add(u);
    }

    visited = new boolean[N + 1];
    dfs(1);

    System.out.println(cnt - 1);
  }

  static void dfs(int start) {
    if(visited[start]) return;

    visited[start] = true;
    cnt++;

    for (int next : graph[start]) {
      dfs(next);
    }
  }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static int N, M, A, B, C;
  static List<int[]>[] graph;
  static boolean[] visited;
  static int maxW = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    A = sc.nextInt();
    B = sc.nextInt();
    C = sc.nextInt();

    graph = new List[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int w = sc.nextInt();

      graph[u].add(new int[]{v, w});
      graph[v].add(new int[]{u, w});
    }


    visited = new boolean[N + 1];
    visited[A] = true;
    dfs(A, 0, 0);

    System.out.println(maxW == Integer.MAX_VALUE ? -1 : maxW);

  }

  static void dfs(int idx, int sum, int max) {
    if (sum > C) {
      return;
    }

    if (idx == B) {
      maxW = Math.min(maxW, max);
      return;
    }

    for (int[] next : graph[idx]) {
      int v = next[0];
      int w = next[1];

      if (visited[v]) continue;
      
      int newMax = Math.max(max, w);
      visited[v] = true;
      dfs(v, sum + w, newMax);
      visited[v] = false;
    }
  }
}
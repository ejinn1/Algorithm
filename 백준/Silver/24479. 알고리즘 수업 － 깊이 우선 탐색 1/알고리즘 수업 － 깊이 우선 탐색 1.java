import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
  static int N, M, R;
  static List<Integer>[] graph;
  static boolean[] visited;
  static int cnt = 1;
  static int[] order;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    R = sc.nextInt();

    graph = new List[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      graph[u].add(v);
      graph[v].add(u);
    }

    visited = new boolean[N + 1];
    order = new int[N];
    dfs(R);

    for (int cnt : order) {
      System.out.println(cnt);
    }
  }

  static void dfs(int node) {
    if(visited[node]) return;
    visited[node] = true;
    order[node - 1] = cnt;
    cnt++;

    graph[node].sort(Comparator.comparing(Integer::valueOf));
    for (int next : graph[node]) {
      if(visited[next]) continue;
      dfs(next);
    }
  }
}
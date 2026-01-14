import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int t = 0; t < T; t++) {
      int V = sc.nextInt();
      int E = sc.nextInt();

      List<Integer>[] graph = new List[V + 1];
      for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

      for (int e = 0; e < E; e++) {
        int u = sc.nextInt();
        int v = sc.nextInt();

        graph[u].add(v);
        graph[v].add(u);
      }

      boolean result = true;
      int[] color = new int[V + 1];
      for (int i = 1; i <= V; i++) {
        if (color[i] == 0) {
          result = bfs(color, i, graph);
          if(!result) break;
        }
      }

      System.out.println(result ? "YES" : "NO");
    }
  }

  static boolean bfs(int[] color, int start, List<Integer>[] graph) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    color[start] = 1;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : graph[cur]) {
        if (color[next] == 0) {
          color[next] = -color[cur];
          q.add(next);
        } else if (color[next] == color[cur]) {
          return false;
        }
      }
    }

    return true;
  }
}
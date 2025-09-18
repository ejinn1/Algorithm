

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static class Edge {
    int to, w;
    Edge(int to, int w){
      this.to = to;
      this.w = w;
    }
  }
  static int V, E, K;
  static List<Edge>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());

    graph = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[u].add(new Edge(v, w));
    }

    final int INF = 1_000_000_000;
    int[] dist = new int[V + 1];
    Arrays.fill(dist, INF);

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    dist[K] = 0;
    pq.offer(new int[]{0, K});

    boolean[] visited = new boolean[V + 1];
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int d = cur[0];
      int v = cur[1];
      if(visited[v]) continue;
      visited[v] = true;

      for (Edge next : graph[v]) {
        int nd = d + next.w;
        if (nd < dist[next.to]) {
          dist[next.to] = nd;
          pq.offer(new int[]{nd, next.to});
        }
      }
    }

    for (int i = 1; i <= V; i++) {
      System.out.println(dist[i] == INF ? "INF" : dist[i]);
    }

  }
}

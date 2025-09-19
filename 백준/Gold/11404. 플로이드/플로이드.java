

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static class Edge {
    int to, w;

    Edge(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    Map<Integer, Integer>[] comp = new HashMap[N + 1];
    for (int i = 1; i <= N; i++) comp[i] = new HashMap<>();

    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      comp[u].merge(v, w, Math::min);
    }

    List<Edge>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++){
      graph[i] = new ArrayList<>();
      for (Map.Entry<Integer, Integer> e : comp[i].entrySet()) {
        graph[i].add(new Edge(e.getKey(), e.getValue()));
      }
    }

    int[][] dist = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    for (int i = 1; i <= N; i++) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
      pq.offer(new int[]{i, 0});
      dist[i][i] = 0;
      boolean[] visited = new boolean[N + 1];

      while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int node = cur[0];
        int weight = cur[1];

        if (visited[node]) continue;
        visited[node] = true;

        for (Edge next : graph[node]) {
          int nw = next.w + weight;
          if (dist[i][next.to] > nw) {
            dist[i][next.to] = nw;
            pq.offer(new int[]{next.to, nw});
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        sb.append(dist[i][j] == Integer.MAX_VALUE ? 0 : dist[i][j])
                .append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}

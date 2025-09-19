

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    List<Edge>[] graph = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[u].add(new Edge(v, w));
    }

    int[][] dist = new int[V + 1][V + 1];
    for (int i = 1; i <= V; i++) {
      for (int j = 1; j <= V; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    for (int i = 1; i <= V; i++) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
      pq.offer(new int[]{i, 0});
      dist[i][i] = 0;

      while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int node = cur[0];
        int weight = cur[1];
        if(dist[i][node] != weight) continue;

        for (Edge next : graph[node]) {
          int nw = next.w + weight;
          if (dist[i][next.to] > nw) {
            dist[i][next.to] = nw;
            pq.offer(new int[]{next.to, nw});
          }
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= V; i++) {
      for (int j = 1; j <= V; j++) {
        int go = dist[i][j];
        int back = dist[j][i];
        if(go == Integer.MAX_VALUE || go == -1 || go == 0) continue;
        if(back == Integer.MAX_VALUE || back == -1 || back == 0) continue;

        min = Math.min(min, go + back);

      }
    }

    System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    



  }

}

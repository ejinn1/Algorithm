

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static class Edge{
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

    List<Edge>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[u].add(new Edge(v, w));
      graph[v].add(new Edge(u, w));
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[]{1, 0});
    boolean[] visited = new boolean[N + 1];
    long sum = 0;
    int picked = 0;

    while (!pq.isEmpty() && picked < N) {
      int[] cur = pq.poll();
      int node = cur[0];
      int weight = cur[1];

      if(visited[node]) continue;
      visited[node] = true;
      sum += weight;
      picked++;

      for (Edge next : graph[node]) {
        if (!visited[next.to]) {
          pq.offer(new int[]{next.to, next.w});
        }
      }
    }

    System.out.println(sum);

  }
}

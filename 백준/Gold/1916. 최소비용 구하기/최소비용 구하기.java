

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
    }

    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    boolean[] visited = new boolean[N + 1];
    pq.offer(new int[]{start, 0});
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int node = cur[0];
      int weight = cur[1];
      if(visited[node]) continue;
      visited[node] = true;

      for (Edge next : graph[node]) {
        int nw = weight + next.w;
        if (dist[next.to] > nw) {
          dist[next.to] = nw;
          pq.offer(new int[]{next.to, nw});
        }
      }
    }

    System.out.println(dist[end]);
    

  }

}

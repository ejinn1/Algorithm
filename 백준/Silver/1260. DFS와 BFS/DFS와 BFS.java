

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, M, V;
  static List<Integer>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    dfs();
    bfs();
  }

  static void dfs() {
    Deque<Integer> stack = new ArrayDeque<>();
    boolean[] visited = new boolean[N + 1];
    stack.push(V);

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      int cur = stack.pop();
      if(visited[cur]) continue;
      visited[cur] = true;
      sb.append(cur + " ");
      
      List<Integer> adj = graph[cur];
      for (int i = adj.size() - 1; i >= 0; i--) {
        int next = adj.get(i);
        if (!visited[next]) stack.push(next);
      }
    }
    System.out.println(sb);
  }

  static void bfs() {
    Deque<Integer> pq = new ArrayDeque<>();
    boolean[] visited = new boolean[N + 1];
    pq.offer(V);
    visited[V] = true;

    StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()) {
      int cur = pq.poll();
      sb.append(cur + " ");

      for (int next : graph[cur]) {
        if(visited[next]) continue;
        visited[next] = true;
        pq.offer(next);
      }
    }

    System.out.println(sb);
  }
}

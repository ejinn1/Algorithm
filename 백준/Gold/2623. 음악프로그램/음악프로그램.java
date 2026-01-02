import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    List<Integer>[] graph = new List[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    int[] indegree = new int[N + 1];
    for (int i = 0; i < M; i++) {
      int K = sc.nextInt();
      int u = sc.nextInt();
      for (int j = 0; j < K - 1; j++) {
        int v = sc.nextInt();
        graph[u].add(v);
        indegree[v]++;
        u = v;
      }
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        pq.add(i);
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      int cur = pq.poll();

      result.add(cur);

      for (int next : graph[cur]) {
        indegree[next]--;
        if (indegree[next] == 0) {
          pq.offer(next);
        }
      }
    }

    if (result.size() == N) {
      for (int x : result) {
        System.out.println(x);
      }
    } else {
      System.out.println(0);
    }
  }
}
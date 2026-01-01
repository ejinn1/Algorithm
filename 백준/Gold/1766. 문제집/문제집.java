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
      int a = sc.nextInt();
      int b = sc.nextInt();

      graph[a].add(b);
      indegree[b]++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        pq.offer(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      int cur = pq.poll();

      sb.append(cur)
              .append(" ");

      for (int next : graph[cur]) {
        indegree[next]--;
        if (indegree[next] == 0) {
          pq.offer(next);
        }
      }
    }

    System.out.println(sb);
  }
}
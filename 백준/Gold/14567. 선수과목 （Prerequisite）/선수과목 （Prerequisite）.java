import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    List<Integer>[] graph = new List[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    int[] indegree = new int[N + 1];
    int[] step = new int[N + 1];

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
        step[i] = 1;
      }
    }

    while (!pq.isEmpty()) {
      int cur = pq.poll();

      for (int next : graph[cur]) {
        indegree[next]--;
        step[next] = Math.max(step[next], step[cur] + 1);

        if (indegree[next] == 0) {
          pq.offer(next);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++){
      sb.append(step[i])
              .append(" ");
    }

    System.out.println(sb);
  }
}
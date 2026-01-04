import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();


    List<Integer>[] graph = new List[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    int[] time = new int[N + 1];
    int[] indegree = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      int t = sc.nextInt();
      time[i] = t;

      int k = sc.nextInt();
      for (int j = 0; j < k; j++) {
        int b = sc.nextInt();
        graph[b].add(i);
        indegree[i]++;
      }
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int[] dp = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        pq.offer(i);
        dp[i] = time[i];
      }
    }

    while (!pq.isEmpty()) {
      int cur = pq.poll();

      for (int next : graph[cur]) {
        dp[next] = Math.max(dp[next], dp[cur] + time[next]);

        indegree[next]--;
        if (indegree[next] == 0) {
          pq.offer(next);

        }
      }
    }

    System.out.println(Arrays.stream(dp)
            .max().getAsInt());
  }
}
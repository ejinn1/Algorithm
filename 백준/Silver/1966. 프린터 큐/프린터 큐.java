import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();

    for (int t = 0; t < testCase; t++) {
      int N = sc.nextInt();
      int M = sc.nextInt();

      Queue<int[]> q = new ArrayDeque<>();
      for (int i = 0; i < N; i++) {
        q.add(new int[]{i, sc.nextInt()});
      }

      int cnt = 1;
      while (!q.isEmpty()) {
        int[] front = q.poll();

        int idx = 0;
        boolean isMax = true;
        for (int[] x : q) {
          if (x[1] > front[1]) {
            isMax = false;
            break;
          }
          idx++;
        }

        if (isMax) {
          if (front[0] == M) {
            break;
          }
          cnt++;
        } else {
          q.add(front);
          for (int i = 1; i < idx; i++) {
            q.add(q.poll());
          }
        }
      }

      System.out.println(cnt);
    }
  }
}
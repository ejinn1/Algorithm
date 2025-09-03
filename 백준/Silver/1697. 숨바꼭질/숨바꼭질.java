

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static int MAX = 100_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    if (N >= K) {
      System.out.println(N - K);
      return;
    }

    int[] dist = new int[MAX + 1];
    Arrays.fill(dist, -1);

    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(N);
    dist[N] = 0;

    while (!q.isEmpty()) {
      int x = q.poll();
      if (x == K) {
        System.out.println(dist[x]);
        return;
      }

      int[] nx = {x - 1, x + 1, x * 2};
      for (int y : nx) {
        if(y < 0 || y > MAX) continue;
        if(dist[y] != -1) continue;
        dist[y] = dist[x] + 1;
        q.add(y);
      }
    }
  }
}

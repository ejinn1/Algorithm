import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    int[][] jewels = new int[N][2];
    for (int i = 0; i < N; i++) {
      int m = sc.nextInt();
      int v = sc.nextInt();

      jewels[i] = new int[]{m, v};
    }

    int[] bags = new int[K];
    for (int i = 0; i < K; i++) bags[i] = sc.nextInt();

    Arrays.sort(jewels, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(bags);

    long result = 0;
    int j = 0;
    PriorityQueue<Integer> can = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < K; i++) {
      int c = bags[i];

      while (j < N && jewels[j][0] <= c) {
        can.offer(jewels[j][1]);
        j++;
      }

      if (!can.isEmpty()) {
        result += can.poll();
      }
    }

    System.out.println(result);
  }
}
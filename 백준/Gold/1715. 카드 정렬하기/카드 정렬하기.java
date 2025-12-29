import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      pq.offer(x);
    }

    int result = 0;
    while (!pq.isEmpty()) {
      if (pq.size() >= 2) {
        int a = pq.poll();
        int b = pq.poll();

        result += a + b;
        pq.offer(a + b);
      } else {
        break;
      }
    }

    System.out.println(result);

  }
}
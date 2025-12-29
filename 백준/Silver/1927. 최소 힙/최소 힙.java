import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      if (x == 0) {
        System.out.println(!pq.isEmpty() ? pq.poll() : 0);
      } else {
        pq.offer(x);
      }
    }
  }
}
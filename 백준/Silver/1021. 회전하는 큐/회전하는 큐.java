import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      dq.add(i);
    }

    int cnt = 0;
    for (int i = 0; i < M; i++) {
      int k = sc.nextInt();

      int idx = 0;
      for (int x : dq) {
        if (x == k) break;
        idx++;
      }

      int left = idx;
      int right = dq.size() - idx;

      if (left <= right) {
        while (dq.getFirst() != k) {
          int x = dq.removeFirst();
          dq.addLast(x);
          cnt++;
        }
        dq.removeFirst();
      } else {
        while (dq.getFirst() != k) {
          int x = dq.removeLast();
          dq.addFirst(x);
          cnt++;
        }
        dq.removeFirst();
      }

    }

    System.out.println(cnt);
  }
}
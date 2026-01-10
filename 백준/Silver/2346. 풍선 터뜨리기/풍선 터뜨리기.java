import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    Deque<int[]> dq = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      dq.add(new int[]{i, sc.nextInt()});
    }

    int idx = 1;
    StringBuilder sb = new StringBuilder();
    while (!dq.isEmpty()) {
      int[] cur;
      if (idx >= 0) {
        for (int i = 1; i < idx; i++) {
          dq.addLast(dq.removeFirst());
        }
        cur = dq.removeFirst();
      } else {
        for (int i = 1; i < Math.abs(idx); i++) {
          dq.addFirst(dq.removeLast());
        }
        cur = dq.removeLast();
      }
      
      idx = cur[1];
      sb.append(cur[0])
              .append(" ");
    }

    System.out.println(sb);
  }
}
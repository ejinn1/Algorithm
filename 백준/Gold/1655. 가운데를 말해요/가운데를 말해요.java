import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());

      if (left.size() == right.size()) {
        left.offer(x);
      } else {
        right.offer(x);
      }

      if (!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
        int big = left.poll();
        int small = right.poll();
        left.offer(small);
        right.offer(big);
      }

      System.out.println(left.peek());
    }

  }
}
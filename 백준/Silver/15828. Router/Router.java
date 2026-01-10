import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int x;
    Queue<Integer> q = new ArrayDeque<>();
    while ((x = sc.nextInt()) != -1) {
      if(x == 0) {
        q.poll();
      } else if (q.size() < N) {
        q.add(x);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int a : q) {
      sb.append(a)
              .append(" ");
    }

    System.out.println(q.isEmpty() ? "empty" : sb);

  }
}
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int result = 0;
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      if (stack.isEmpty()) {
        stack.push(y);
        continue;
      }

      while (!stack.isEmpty() && stack.peek() > y) {
        stack.pop();
        result++;
      }

      if ((stack.isEmpty() || stack.peek() < y) && y != 0) {
        stack.push(y);
      }
    }

    while (!stack.isEmpty()) {
      int k = stack.pop();
      if (k != 0) {
        result++;
      }
    }

    System.out.println(result);

  }
}
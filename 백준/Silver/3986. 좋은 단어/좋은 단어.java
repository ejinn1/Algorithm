import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();

    int result = 0;
    for (int i = 0; i < N; i++) {
      char[] str = sc.nextLine().toCharArray();
      Stack<Character> stack = new Stack<>();

      for (char ch : str) {
        if (stack.isEmpty()) {
          stack.add(ch);
        } else if (stack.peek() == ch) {
          stack.pop();
        } else {
          stack.add(ch);
        }
      }

      if (stack.isEmpty()) {
        result++;
      }
    }

    System.out.println(result);

  }
}
import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[] str = sc.nextLine()
            .toCharArray();

    Stack<Character> stack = new Stack<>();
    Stack<Integer> score = new Stack<>();
    score.push(0);

    for (char ch : str) {
      if (ch == '(' || ch == '[') {
        stack.push(ch);
        score.push(0);
      } else if (ch == ')') {
        if (stack.isEmpty() || stack.pop() != '(') {
          System.out.println(0);
          return;
        }

        int prev = score.pop();
        int cur = (prev == 0 ? 2 : prev * 2);
        score.push(score.pop() + cur);
      } else if (ch == ']') {
        if (stack.isEmpty() || stack.pop() != '[') {
          System.out.println(0);
          return;
        }

        int prev = score.pop();
        int cur = (prev == 0 ? 3 : prev * 3);
        score.push(score.pop() + cur);
      }
    }

    if (!stack.isEmpty() || score.size() != 1) {
      System.out.println(0);
      return;
    }

    System.out.println(score.pop());
  }
}

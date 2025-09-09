

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while(true){
      String str = br.readLine();
      if(str.equals(".")) break;

      Stack<Character> stack = new Stack<>();
      boolean isValid = true;

      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == '[' || c == '(') {
          stack.push(c);
        } else if (c == ']') {
          if (stack.isEmpty() || stack.peek() != '[') {
            isValid = false;
            break;
          }
          stack.pop();
        } else if (c == ')') {
          if (stack.isEmpty() || stack.peek() != '(') {
            isValid = false;
            break;
          }
          stack.pop();
        }
      }

      if (!stack.isEmpty()) isValid = false;
      System.out.println(isValid ? "yes" : "no");
    }
  }
}

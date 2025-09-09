

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String option = st.nextToken();
      if (option.equals("push")) {
        int value = Integer.parseInt(st.nextToken());
        stack.push(value);
      } else if (option.equals("pop")) {
        if(!stack.isEmpty()){
          System.out.println(stack.pop());
        } else System.out.println(-1);
      } else if (option.equals("size")) {
        System.out.println(stack.size());
      } else if (option.equals("empty")) {
        if(stack.isEmpty()) System.out.println(1);
        else System.out.println(0);
      } else if (option.equals("top")) {
        if(stack.isEmpty()) System.out.println(-1);
        else System.out.println(stack.peek());
      }
    }

  }

}

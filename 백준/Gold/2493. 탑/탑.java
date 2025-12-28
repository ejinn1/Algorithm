import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] tops = new int[N + 1];
    String[] line = br.readLine()
            .split(" ");
    for (int i = 1; i <= N; i++) {
      tops[i] = Integer.parseInt(line[i - 1]);
    }

    int[] result = new int[N + 1];
    Stack<int[]> stack = new Stack<>();
    int max = 0;
    for (int i = 1; i <= N; i++) {
      int h = tops[i];

      while (!stack.isEmpty() && stack.peek()[0] < h) {
        stack.pop();
      }

      result[i] = stack.isEmpty() ? 0 : stack.peek()[1];

      stack.push(new int[]{h, i});
    }


    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(result[i]).append(' ');
    }
    System.out.print(sb);
  }
}

// 5
// 5 3 4 2 6
// 0 1 1 3 0
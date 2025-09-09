

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Queue<Integer> q = new LinkedList<>();
    Integer last = -1;

    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String option = st.nextToken();

      if (option.equals("push")) {
        int value = Integer.parseInt(st.nextToken());
        q.add(value);
        last = value;
      } else if (option.equals("pop")) {
        sb.append(q.isEmpty() ? -1 : q.poll())
                .append("\n");
      } else if (option.equals("size")) {
        sb.append(q.size())
                .append("\n");
      } else if (option.equals("empty")) {
        sb.append(q.isEmpty() ? 1 : 0)
                .append("\n");
      } else if (option.equals("front")) {
        sb.append(q.isEmpty() ? -1 : q.peek())
                .append("\n");
      } else if (option.equals("back")) {
        sb.append(q.isEmpty() ? -1 : last)
                .append("\n");
      }
    }

    System.out.println(sb);
  }
}

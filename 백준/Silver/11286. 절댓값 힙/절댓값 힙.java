

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> minH = new PriorityQueue<>((a, b) -> {
      int A = Math.abs(a);
      int B = Math.abs(b);
      if(A != B) return A - B;
      return a - b;
    });
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());

      if (x == 0) {
        if(!minH.isEmpty()){
          sb.append(minH.peek());
          minH.poll();
        } else {
          sb.append(0);
        }
        sb.append("\n");
      } else {
        minH.offer(x);
      }
    }

    System.out.println(sb);

  }

}

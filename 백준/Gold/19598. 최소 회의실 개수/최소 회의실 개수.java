

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<int[]> room = new PriorityQueue<>((a, b) -> {
      if(a[0] == b[0]){
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      room.add(new int[]{s, e});
    }

    int max = 0;
    PriorityQueue<Integer> endTimes = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int[] cur = room.poll();
      int s = cur[0], e = cur[1];

      while (!endTimes.isEmpty() && endTimes.peek() <= s) {
        endTimes.poll();
      }

      endTimes.offer(e);
      max = Math.max(max, endTimes.size());
    }

    System.out.println(max);
  }
}

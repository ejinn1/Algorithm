

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    int[] trucks = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      trucks[i] = Integer.parseInt(st.nextToken());
    }

    Queue<Integer> bridge = new ArrayDeque<>();
    int time = 0;
    int curWeight = 0;
    int i = 0;

    while (i < n) {
      time++;

      if (bridge.size() == w) {
        curWeight -= bridge.poll();
      }

      if (i < n && curWeight + trucks[i] <= l) {
        bridge.add(trucks[i]);
        curWeight += trucks[i];
        i++;
      } else {
        bridge.add(0);
      }
    }

    System.out.println(time + w);
  }
}

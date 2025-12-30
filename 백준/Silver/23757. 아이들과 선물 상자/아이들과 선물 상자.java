import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) presents.add(Integer.parseInt(st.nextToken()));

    int[] children = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) children[i] = Integer.parseInt(st.nextToken());

    boolean result = true;
    for (int i = 0; i < M; i++) {
      int c = children[i];

      if(presents.isEmpty()){
        result = false;
        break;
      }
      int p = presents.poll();

      if (c > p) {
        result = false;
        break;
      } else if (p - c > 0) {
        presents.offer(p - c);
      }
    }

    System.out.println(result ? 1 : 0);
  }
}
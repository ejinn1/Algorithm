import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    final int MAX = 1_500_000;
    int[] next = new int[MAX + 1];
    int[] prev = new int[MAX + 1];

    st = new StringTokenizer(br.readLine());
    int first = Integer.parseInt(st.nextToken());
    int prevStation = first;
    for (int i = 1; i < N; i++) {
      int cur = Integer.parseInt(st.nextToken());
      next[prevStation] = cur;
      prev[cur] = prevStation;

      prevStation = cur;
    }

    next[prevStation] = first;
    prev[first] = prevStation;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      String order = st.nextToken();

      if (order.equals("BN")) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        sb.append(next[x])
                .append("\n");

        int t = next[x];
        next[x] = y;
        prev[t] = y;
        next[y] = t;
        prev[y] = x;
      } else if (order.equals("BP")) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        sb.append(prev[x])
                .append("\n");

        int t = prev[x];
        prev[x] = y;
        next[t] = y;
        prev[y] = t;
        next[y] = x;
      } else if (order.equals("CN")) {
        int x = Integer.parseInt(st.nextToken());

        sb.append(next[x])
                .append("\n");

        int t = next[x];
        int nn = next[t];
        next[x] = nn;
        prev[nn] = x;
      } else if (order.equals("CP")) {
        int x = Integer.parseInt(st.nextToken());

        sb.append(prev[x])
                .append("\n");

        int t = prev[x];
        int pp = prev[t];
        prev[x] = pp;
        next[pp] = x;
      }
    }
    System.out.println(sb);
  }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int test = 1; test <= T; test++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      int cnt = 0;
      if (a % 2 == 0) {
        cnt += 1;
      }
      if (b % 2 == 0) {
        cnt += 1;
      }
      if (c % 2 == 0) {
        cnt += 1;
      }

      if (cnt != 0) {
        System.out.println(1);
      } else {
        System.out.println(2);
      }

    }
  }

}
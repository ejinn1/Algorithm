import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    String[] colors = new String[]{"red", "orange", "yellow", "green", "blue", "purple"};
    int N = 6;

    for (int test = 0; test < T; test++) {
      String[] inputs = br.readLine().split(" ");
      String a = inputs[0];
      String b = inputs[1];
      int ia = Arrays.asList(colors)
              .indexOf(a);
      int ib = Arrays.asList(colors)
              .indexOf(b);

      if (a.equals(b)) {
        System.out.println("E");
      } else if (Math.abs(ia % N - ib % N) == 1 || Math.abs(ia % N - ib % N) == 5 ) {
        System.out.println('A');
      } else if (Math.abs(ia % N - ib % N) == 3) {
        System.out.println('C');
      } else {
        System.out.println("X");
      }
    }
  }
}

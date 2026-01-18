import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] board = new int[N][2];

    for (int i = 0; i < N; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      board[i] = new int[]{l, r};
    }

    Arrays.sort(board, (a, b) -> {
      if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
      return Integer.compare(a[1], b[1]);
    });

    ArrayList<int[]> seg = new ArrayList<>();
    int L = board[0][0];
    int R = board[0][1];

    for (int i = 1; i < N; i++) {
      int l = board[i][0];
      int r = board[i][1];

      if (l <= R) {
        R = Math.max(r, R);
      } else {
        seg.add(new int[]{L, R});
        L = l;
        R = r;
      }
    }
    seg.add(new int[]{L, R});

    long reachR = seg.get(0)[1];
    long jumpReach = 2L * seg.get(0)[1] - seg.get(0)[0];

    for (int i = 1; i < seg.size(); i++) {
      long l = seg.get(i)[0];
      long r = seg.get(i)[1];

      if(l > jumpReach) break;
      reachR = Math.max(reachR, r);
      jumpReach = Math.max(jumpReach, 2L * r - l);
    }

    System.out.println(reachR);
  }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int L = sc.nextInt();

    int[][] map = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    int[][] lines = new int[2 * N][N];

    for (int i = 0; i < N; i++) {
      lines[i] = map[i];
//      System.out.println("line" + Arrays.toString(lines[i]));
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        lines[i + N][j] = map[j][i];
      }
//      System.out.println("line" + Arrays.toString(lines[i + N]));
    }

    int result = 0;

    for (int i = 0; i < 2 * N; i++) {
      int[] line = lines[i];
      boolean[] used = new boolean[N];
      int j = 0;
      while (j < N - 1) {
        int cur = line[j];
        int next = line[j + 1];

        if(cur == next){
          j++;
          continue;
        }

        boolean pass = true;
        boolean up = true;
        if (next == cur + 1) {
          for (int k = j - L + 1; k <= j; k++) {
            if (k < 0 || line[k] != cur || used[k]) {
              pass = false;
              break;
            } else {
              used[k] = true;
            }
          }
        } else if (next == cur - 1) {
          up = false;
          for (int k = j + 1; k <= j + L; k++) {
            if (k > N - 1 || line[k] != next | used[k]) {
              pass = false;
              break;
            } else {
              used[k] = true;
            }
          }
        } else {
          break;
        }

        if(!pass) break;
        if (up) j++;
        else j += L;
      }
      if (j == N - 1) {
        result++;
      }
    }

    System.out.println(result);
  }
}
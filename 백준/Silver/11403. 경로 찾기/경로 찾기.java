

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[][] load = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      Arrays.fill(load[i], -1);
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        load[i][j] = sc.nextInt();
      }
    }

    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if(load[i][k] == 1 && load[k][j] == 1) load[i][j] = 1;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        sb.append(load[i][j] + " ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }


}

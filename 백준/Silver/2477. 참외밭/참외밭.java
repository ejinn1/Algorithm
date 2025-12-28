import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();
    int N = 6;

    int maxH = 0;
    int maxV = 0;

    int[][] hexagon = new int[N][2];

    for (int i = 0; i < N; i++) {
      int j = sc.nextInt();
      int meter = sc.nextInt();

      hexagon[i][0] = j;
      hexagon[i][1] = meter;

      if (j == 1 || j == 2) {
        maxV = Math.max(maxV, meter);
      } else {
        maxH = Math.max(maxH, meter);
      }
    }

    int large = maxH * maxV;

    int small;
    int idx = 0;
    while (true) {
      if (hexagon[idx][0] == hexagon[(idx + 2) % N][0] && hexagon[(idx + 1) % 6][0] == hexagon[(idx + 3) % N][0]) {
        small = hexagon[(idx + 2) % N][1] * hexagon[(idx + 1) % 6][1];
        break;
      }
      idx++;
    }

    System.out.println(K * (large - small));
  }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static int N, M, H, C;
  static int[][] arr, dist;
  static ArrayList<int[]> houses, chickens;
  static boolean[] selected;
  static int res = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[N][N];

    houses = new ArrayList<>();
    chickens = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = sc.nextInt();
        if (arr[i][j] == 1) {
          houses.add(new int[]{i, j});
        } else if (arr[i][j] == 2) {
          chickens.add(new int[]{i, j});
        }
      }
    }

    H = houses.size();
    C = chickens.size();
    dist = new int[H][C];
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < C; j++) {
        int d = Math.abs(houses.get(i)[0] - chickens.get(j)[0]) + Math.abs(houses.get(i)[1] - chickens.get(j)[1]);
        dist[i][j] = d;
      }
    }

    selected = new boolean[C];
    dfs(0, 0);

    System.out.println(res);

  }

  static void dfs(int idx, int picked) {
    if (picked == M) {
      int sum = 0;
      for (int i = 0; i < H; i++) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < C; j++) {
          if (selected[j]) {
            min = Math.min(min, dist[i][j]);
          }
        }
        sum += min;
      }
      res = Math.min(res, sum);
      return;
    }

    for (int i = idx; i < C; i++) {
      selected[i] = true;
      dfs(i + 1, picked + 1);
      selected[i] = false;
    }
  }
}
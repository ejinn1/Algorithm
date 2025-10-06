

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] arr;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    arr = new int[100][100];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < R; i++) {
      int num = Integer.parseInt(st.nextToken());
      switch (num) {
        case 1: 
          num1();
          break;
        case 2:
          num2();
          break;
        case 3:
          num3();
          break;
        case 4: 
          num4();
          break;
        case 5:
          num5();
          break;
        case 6:
          num6();
          break;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sb.append(arr[i][j])
                .append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }

  static void num1(){
    int[][] tmp = new int[100][100];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        tmp[N - i - 1][j] = arr[i][j];
      }
    }

    arr = tmp;
  }

  static void num2() {
    int[][] tmp = new int[100][100];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        tmp[i][M - j - 1] = arr[i][j];
      }
    }

    arr = tmp;
  }

  static void num3() {
    int[][] tmp = new int[100][100];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        tmp[j][N - i - 1] = arr[i][j];
      }
    }

    arr = tmp;
    int t = N;
    N = M;
    M = t;
  }

  static void num4() {
    int[][] tmp = new int[100][100];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        tmp[M - j - 1][i] = arr[i][j];
      }
    }

    arr = tmp;
    int t = N;
    N = M;
    M = t;
  }

  static void num5() {
    int[][] tmp = new int[100][100];
    int hN = N / 2, hM = M / 2;

    for (int i = 0; i < hN; i++) {
      for (int j = 0; j < hM; j++) {
        tmp[i][j + hM] = arr[i][j];
        tmp[i + hN][j + hM] = arr[i][j + hM];
        tmp[i + hN][j] = arr[i + hN][j + hM];
        tmp[i][j] = arr[i + hN][j];
      }
    }

    arr = tmp;
  }

  static void num6() {
    int[][] tmp = new int[100][100];
    int hN = N / 2, hM = M / 2;

    for (int i = 0; i < hN; i++) {
      for (int j = 0; j < hM; j++) {
        tmp[i + hN][j] = arr[i][j];
        tmp[i][j] = arr[i][j + hM];
        tmp[i][j + hM] = arr[i + hN][j + hM];
        tmp[i + hN][j + hM] = arr[i + hN][j];
      }
    }

    arr = tmp;
  }
}
